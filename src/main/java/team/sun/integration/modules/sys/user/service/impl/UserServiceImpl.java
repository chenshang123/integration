package team.sun.integration.modules.sys.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.google.common.collect.Sets;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.util.ReflectionUtils;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.config.base.tool.reflect.ReflectionKit;
import team.sun.integration.config.base.tool.reflect.TestVo;
import team.sun.integration.modules.bulldozer.extend.querydsl.criteria.SearchCriteria;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.repository.RoleDao;
import team.sun.integration.modules.sys.user.model.entity.QUser;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.model.vo.UserRoleVO;
import team.sun.integration.modules.sys.user.model.vo.page.UserPageVo;
import team.sun.integration.modules.sys.user.repository.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.sun.integration.modules.sys.user.service.UserService;

import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 系统-用户 服务实现类
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User save(User entity) {
        if (StringUtils.isBlank(entity.getPwd())) {
            entity.setPwd(RandomUtil.randomString(6));
        }
        this.generatePassword(entity);
        return dao.save(entity);
    }

    @Override
    public User update(User entity) {
        if (StringUtils.isNotBlank(entity.getPwd())) {
            generatePassword(entity);
        } else {
            entity.setPwd(null);
        }
        entity.setUsername(null);//禁止修改用户名
        return dao.save(entity);
    }

    @Override
    public PageRet<UserPageVo> page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {

        QUser user = QUser.user;
        BlazeJPAQuery<User> jpaQuery = new BlazeJPAQuery<User>(entityManager, criteriaBuilderFactory)
                .from(user)
                .where(predicate).orderBy(user.id.asc().nullsLast());
        List<UserPageVo> data = new ArrayList<>();
        Optional.ofNullable(
                jpaQuery.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch()
        ).orElseGet(ArrayList::new).stream().filter(Objects::nonNull).forEach(o -> {
            UserPageVo vo = new UserPageVo();
            BeanUtils.copyProperties(o, vo);
            data.add(vo);
        });
        long count = jpaQuery.fetchCount();
        JPAQuery<User> query = jpaQueryFactory.selectFrom(user).where(predicate);
        return new PageRet<>(data, count);
    }

    @Override
    public List<String> getRoleIds(String userId) {
        List<String> roleIds = new ArrayList<>();
        Optional<User> user = dao.findById(userId);
        user.flatMap(o -> Optional.ofNullable(o.getUserRoles())).
                ifPresent(roles -> roles.forEach(role -> roleIds.add(role.getId())));
        return roleIds;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void authZRole(String userId, List<String> roleIds) {
        Optional<User> user = dao.findById(userId);
        user.ifPresent(o -> {
            //删除：关系表-角色权限
            o.getUserRoles().clear();
            //添加: 关系表-角色权限
            Iterable<Role> roles = roleDao.findAllById(roleIds);
            o.setUserRoles(Sets.newHashSet(roles));
            dao.save(o);
        });
    }

    @Override
    public UserRoleVO getByUsername(String userName, boolean withRoles) {
        if (StringUtils.isBlank(userName)) {
            return null;
        }
        List<User> users = dao.findByUsername(userName);
        UserRoleVO vo = new UserRoleVO();
        if (!users.isEmpty()) {
            vo.setUser(users.get(0));
            if (withRoles && null != users.get(0).getUserRoles()) {
                users.get(0).getUserRoles().forEach((mid) -> vo.getRoleIds().add(mid.getId()));
            }
        }
        return vo;
    }

    @Override
    public boolean verifyPassword(String password, String rawPassword) {
        if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(rawPassword)) {
            String salt = password.substring(0, 29);
            rawPassword = BCrypt.hashpw(rawPassword, salt);
            return password.equals(rawPassword);
        }
        return false;
    }

    private void generatePassword(User user) {
        String encodePassword = passwordEncoder.encode(user.getPwd());
        user.setPwd(encodePassword);
    }

    public static void main(String[] args) {
        String[] values = {"a", "b"};
        SearchCriteria searchCriteria = new SearchCriteria("", "", "", values);
        //Criteria criteria = new Criteria( "", "", values);
        //Predicate searchPredicate = new Predicate(criteria);
        //searchPredicate.getPredicate();

        User user = new User();
        user.setEmail("email");
        System.out.println(Boolean.class.getTypeName());
        Set<Field> fields = ReflectionUtils.getFields(TestVo.class);
        fields.stream().filter(Objects::nonNull).forEach(o->{
            System.out.print(o.getName()+"-----------------------");
            System.out.print(o.getType()+"-----------------------"+o.getAnnotatedType()+"-----------");
            System.out.println(ReflectionKit.isPrimitiveOrWrapper(o.getType()));
        });


    }


}