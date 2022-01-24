package team.sun.integration.modules.sys.group.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGroup is a Querydsl query type for Group
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGroup extends EntityPathBase<Group> {

    private static final long serialVersionUID = 1092362813L;

    public static final QGroup group = new QGroup("group1");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath creatorDepartmentId = createString("creatorDepartmentId");

    public final StringPath creatorId = createString("creatorId");

    public final StringPath creatorTenantId = createString("creatorTenantId");

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath explain = createString("explain");

    public final StringPath id = createString("id");

    public final StringPath modifierId = createString("modifierId");

    public final StringPath name = createString("name");

    public final SetPath<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole> roles = this.<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole>createSet("roles", team.sun.integration.modules.sys.role.model.entity.Role.class, team.sun.integration.modules.sys.role.model.entity.QRole.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final SetPath<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser> users = this.<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser>createSet("users", team.sun.integration.modules.sys.user.model.entity.User.class, team.sun.integration.modules.sys.user.model.entity.QUser.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QGroup(String variable) {
        super(Group.class, forVariable(variable));
    }

    public QGroup(Path<? extends Group> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroup(PathMetadata metadata) {
        super(Group.class, metadata);
    }

}

