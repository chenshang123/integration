package team.sun.integration.modules.sys.role.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -911251079L;

    public static final QRole role = new QRole("role");

    public final BooleanPath available = createBoolean("available");

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final SetPath<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup> groups = this.<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup>createSet("groups", team.sun.integration.modules.sys.group.model.entity.Group.class, team.sun.integration.modules.sys.group.model.entity.QGroup.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath remarks = createString("remarks");

    public final SetPath<team.sun.integration.modules.sys.permission.model.entity.Permission, team.sun.integration.modules.sys.permission.model.entity.QPermission> rolePermissions = this.<team.sun.integration.modules.sys.permission.model.entity.Permission, team.sun.integration.modules.sys.permission.model.entity.QPermission>createSet("rolePermissions", team.sun.integration.modules.sys.permission.model.entity.Permission.class, team.sun.integration.modules.sys.permission.model.entity.QPermission.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final SetPath<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser> users = this.<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser>createSet("users", team.sun.integration.modules.sys.user.model.entity.User.class, team.sun.integration.modules.sys.user.model.entity.QUser.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

