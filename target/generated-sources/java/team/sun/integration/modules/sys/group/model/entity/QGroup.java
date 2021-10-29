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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGroup group = new QGroup("group1");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final team.sun.integration.modules.sys.user.model.entity.QUser creator;

    public final team.sun.integration.modules.sys.org.model.entity.QOrg creatorDepartment;

    public final team.sun.integration.modules.sys.tenant.model.entity.QTenant creatorTenant;

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath explain = createString("explain");

    public final SetPath<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole> groupRoles = this.<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole>createSet("groupRoles", team.sun.integration.modules.sys.role.model.entity.Role.class, team.sun.integration.modules.sys.role.model.entity.QRole.class, PathInits.DIRECT2);

    public final SetPath<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser> groupUsers = this.<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser>createSet("groupUsers", team.sun.integration.modules.sys.user.model.entity.User.class, team.sun.integration.modules.sys.user.model.entity.QUser.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QGroup(String variable) {
        this(Group.class, forVariable(variable), INITS);
    }

    public QGroup(Path<? extends Group> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGroup(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGroup(PathMetadata metadata, PathInits inits) {
        this(Group.class, metadata, inits);
    }

    public QGroup(Class<? extends Group> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creator = inits.isInitialized("creator") ? new team.sun.integration.modules.sys.user.model.entity.QUser(forProperty("creator"), inits.get("creator")) : null;
        this.creatorDepartment = inits.isInitialized("creatorDepartment") ? new team.sun.integration.modules.sys.org.model.entity.QOrg(forProperty("creatorDepartment"), inits.get("creatorDepartment")) : null;
        this.creatorTenant = inits.isInitialized("creatorTenant") ? new team.sun.integration.modules.sys.tenant.model.entity.QTenant(forProperty("creatorTenant"), inits.get("creatorTenant")) : null;
    }

}

