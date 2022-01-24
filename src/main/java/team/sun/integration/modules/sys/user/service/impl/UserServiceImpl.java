package team.sun.integration.modules.sys.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.google.common.collect.Sets;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.repository.RoleDao;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.tenant.model.vo.page.TenantPageVO;
import team.sun.integration.modules.sys.user.model.dto.save.UserSaveDTO;
import team.sun.integration.modules.sys.user.model.dto.update.UserUpdateDTO;
import team.sun.integration.modules.sys.user.model.entity.QUser;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.model.vo.UserVO;
import team.sun.integration.modules.sys.user.model.vo.login.UserLoginVO;
import team.sun.integration.modules.sys.user.model.vo.page.UserPageVo;
import team.sun.integration.modules.sys.user.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.sun.integration.modules.sys.user.service.UserService;

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
    public User save(UserSaveDTO dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        this.generatePassword(entity);
        return dao.save(entity);
    }

    @Override
    public User update(UserUpdateDTO dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        Optional<User> optional = this.getById(dto.getId());
        optional.ifPresent(user -> {
            generatePassword(optional.get());
            dao.save(optional.get());
        });
        return optional.orElse(null);
    }

    @Override
    public UserVO getUserById(String id) {
        Optional<User> optional = this.dao.findById(id);
        UserVO vo = new UserVO();
        
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QUser user = QUser.user;
        BlazeJPAQuery<User> blazeJPAQuery = new BlazeJPAQuery<User>(entityManager, criteriaBuilderFactory)
                .select(user)
                .from(user)
                .where(predicate).orderBy(user.id.asc().nullsLast());
        PagedList<User> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        List<UserPageVo> pageVOS = new ArrayList<>();
        pages.forEach(entity -> {
            UserPageVo pageVO = new UserPageVo();
            BeanUtils.copyProperties(Objects.requireNonNull(entity), pageVO);
            pageVOS.add(pageVO);
        });
        return new PageRet(pageVOS, pages.getTotalSize());
    }

    @Override
    public List<String> getRoleIds(String userId) {
        List<String> roleIds = new ArrayList<>();
        Optional<User> user = dao.findById(userId);
        user.flatMap(o -> Optional.ofNullable(o.getRoles())).
                ifPresent(roles -> roles.forEach(role -> roleIds.add(role.getId())));
        return roleIds;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void authZRole(String userId, List<String> roleIds) {
        Optional<User> user = dao.findById(userId);
        user.ifPresent(o -> {
            //删除：关系表-角色权限
            o.getRoles().clear();
            //添加: 关系表-角色权限
            Iterable<Role> roles = roleDao.findAllById(roleIds);
            o.setRoles(Sets.newHashSet(roles));
            dao.save(o);
        });
    }

    @Override
    public UserLoginVO getByUsername(String userName, Boolean withRoles) {
        if (!StringUtils.hasLength(userName)) {
            return null;
        }
        User user = this.dao.findByUsername(userName);
        UserLoginVO vo = new UserLoginVO();
        if (null != user) {
            BeanUtils.copyProperties(user, vo);
            if (withRoles && null != user.getRoles()) {
                user.getRoles().forEach((role) -> vo.getRoleIds().add(role.getId()));
            }
        }
        return vo;
    }

    @Override
    public boolean verifyPassword(String password, String rawPassword) {
        if (StringUtils.hasLength(password) && StringUtils.hasLength(rawPassword)) {
            String salt = password.substring(0, 29);
            rawPassword = BCrypt.hashpw(rawPassword, salt);
            return password.equals(rawPassword);
        }
        return false;
    }

    private void generatePassword(User user) {
        if (StringUtils.hasLength(user.getPwd())) {
            String encodePassword = passwordEncoder.encode(user.getPwd());
            user.setPwd(encodePassword);
        } else {
            user.setPwd(RandomUtil.randomString(6));
        }
    }

}