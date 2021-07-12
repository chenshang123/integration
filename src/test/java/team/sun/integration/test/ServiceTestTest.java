package team.sun.integration.test;

import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.*;
import org.springframework.beans.BeanUtils;
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

import java.time.LocalDateTime;
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

        quser.petName.eq("");//字段相等
        quser.petName.ne("");//字段不相等
        quser.petName.gt("");//字段大于
        quser.petName.goe("");//字段大于等于
        quser.petName.lt("");//字段小于
        quser.petName.loe("");//字段小于等于
        quser.petName.between("", "");//字段属于两个值之间
        quser.petName.notBetween("", "");//字段不属于两个值之间
        quser.petName.in("");//字段属于集合
        quser.petName.notIn("", "");//字段不属于集合
        quser.petName.like("");//模糊匹配
        quser.petName.notLike("");//排除模糊匹配结果
        quser.petName.likeIgnoreCase("");//模糊匹配忽略大小写
        quser.petName.startsWith("");//以开始值模糊匹配
        quser.petName.startsWithIgnoreCase("");//以开始值模糊匹配-忽略大小写
        quser.petName.endsWith("");//以结尾值模糊匹配
        quser.petName.endsWithIgnoreCase("");//以结尾值模糊匹配-忽略大小写

        quser.petName.asc().nullsLast();//字段升序-空值在后
        quser.petName.asc().nullsFirst();//字段升序-空值在前
        quser.petName.desc().nullsFirst();
        quser.petName.desc().nullsLast();

        quser.petName.max();//字段最大值
        quser.petName.min();//字段最小值

        quser.petName.matches("");
        quser.allowNotAccess.coalesce(null, LocalDateTime.now());//coalesce(a,b,c);
        //参数说明：如果a==null,则选择b；如果b==null,则选择c；如果a!=null,则选择a；如果a b c 都为null ，则返回为null（没意义）。
        quser.dataAuthorityType.add(1);//加法
        quser.dataAuthorityType.subtract(1);//减法
        quser.dataAuthorityType.multiply(1);//乘法
        quser.dataAuthorityType.divide(2);//除法
        quser.dataAuthorityType.sqrt();//平方根
        quser.dataAuthorityType.mod(1);//余数
        quser.dataAuthorityType.abs();//绝对值

        quser.dataAuthorityType.avg();//平均值

        quser.dataAuthorityType.ceil();//123.45  124.00 / -123.45  -123.00
        quser.dataAuthorityType.negate();
        quser.dataAuthorityType.round();//函数用于把数值字段舍入为指定的小数位数。

        quser.allowNotAccess.after(LocalDateTime.now());
        quser.allowNotAccess.before(LocalDateTime.now());






        new BlazeJPAQuery<>();

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