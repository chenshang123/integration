package team.sun.integration.test;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.*;
import com.querydsl.core.util.ReflectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import team.sun.integration.modules.sys.config.service.CodeValueService;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.org.repository.OrgDao;
import team.sun.integration.modules.sys.org.service.OrgService;
import team.sun.integration.modules.sys.resource.service.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import org.springframework.test.context.junit4.SpringRunner;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.repository.RoleDao;
import team.sun.integration.modules.sys.user.model.entity.QUser;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.model.vo.page.UserPageVo;
import team.sun.integration.modules.sys.user.service.UserService;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTestTest {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CodeValueService codeValueService;

    @Autowired
    private UserService userService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private OrgDao orgDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testModelServiceServiceImpl() {
        QUser quser = QUser.user;

        PathBuilder<User> entityPath = new PathBuilder<User>(User.class, "user");
        SetPath<Org, PathBuilder<Org>> a = entityPath.getSet("org", Org.class);


        //StringPath petName = entityPath.getString("org");

        BooleanExpression param = Expressions.asBoolean(true).isTrue();
        param = param.and(quser.org.id.eq("1"));
        param = param.and(quser.org.firstFloorId.eq("1"));

        Predicate predicate = quser.isNotNull().or(quser.isNull());

        Iterable<User> user2 = userService.get(param);




        System.out.println(entityPath.get("petName", StringPath.class).get(String.valueOf(StringPath.class)));


        List<UserPageVo> data = null;


        Optional.ofNullable(data
        ).orElseGet(() -> {
            List<UserPageVo> data2 = new ArrayList<>();
            UserPageVo vo1 = new UserPageVo();
            vo1.setPetName("one");
            data2.add(vo1);
            vo1 = null;
            UserPageVo vo2 = new UserPageVo();
            vo2.setPetName("two");
            data2.add(vo2);
            return data2;
        }).stream().filter(Objects::nonNull).forEach(o -> {
            System.out.println(o.getPetName());
            o.setPhone("187800000000");
        });


        String rawPassword = "123456";

        String encode = "$2a$10$nC9O9phuVa.gyXYTx4G32OGvQV5EzPk/t7VFwVhxMihAi2Bt.mMIW";
        String salt = encode.substring(0, 29);
        String hash = encode.substring(29, 60);
        rawPassword = BCrypt.hashpw(rawPassword, salt);
        System.out.println(encode);
        System.out.println(rawPassword);
        User dto = new User();

        Org org = new Org();
        User user = new User();
        user = userService.getById("1").get();
        org = user.getOrg();
        Set<Role> role = user.getUserRoles();
        //查询
        System.out.println("--------------------------" + user.toString());
        //System.out.println("--------------------------"+user.getGroups().size());

        //对象拷贝-会copy全属性包括属性对象
        BeanUtils.copyProperties(user, dto);

        //新增
        dto = new User();
        dto.setUsername("test");
        dto.setPetName("昵称");

        //新增-中间关系
        User user1 = userService.getById("40287c8179b224110179b2244b190000").get();
        user1.getUserRoles().clear();

        user1.getUserRoles().add(roleDao.findById("2").get());
        //新增完整数据
        userService.save(user1);
        //修改
        //修改-关联对象数据
        //userService.save(dto);
        //修改-关联关系
        user1 = userService.getById("40287c8179b224110179b2244b190000").get();
        userService.removeById("40287c8179b224110179b2244b190000");
        //删除

        //删除-中间关系

        //删除-完整数据
        System.out.println("--------------------------" + user.getUserRoles().size());
    }


}