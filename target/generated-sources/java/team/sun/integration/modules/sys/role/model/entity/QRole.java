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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRole role = new QRole("role");

    public final BooleanPath available = createBoolean("available");

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final team.sun.integration.modules.sys.user.model.entity.QUser creator;

    public final team.sun.integration.modules.sys.org.model.entity.QOrg creatorDepartment;

    public final team.sun.integration.modules.sys.tenant.model.entity.QTenant creatorTenant;

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final SetPath<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup> groups = this.<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup>createSet("groups", team.sun.integration.modules.sys.group.model.entity.Group.class, team.sun.integration.modules.sys.group.model.entity.QGroup.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath remarks = createString("remarks");

    public final SetPath<team.sun.integration.modules.sys.resource.model.entity.Element, team.sun.integration.modules.sys.resource.model.entity.QElement> roleElements = this.<team.sun.integration.modules.sys.resource.model.entity.Element, team.sun.integration.modules.sys.resource.model.entity.QElement>createSet("roleElements", team.sun.integration.modules.sys.resource.model.entity.Element.class, team.sun.integration.modules.sys.resource.model.entity.QElement.class, PathInits.DIRECT2);

    public final SetPath<team.sun.integration.modules.sys.resource.model.entity.Resource, team.sun.integration.modules.sys.resource.model.entity.QResource> roleResources = this.<team.sun.integration.modules.sys.resource.model.entity.Resource, team.sun.integration.modules.sys.resource.model.entity.QResource>createSet("roleResources", team.sun.integration.modules.sys.resource.model.entity.Resource.class, team.sun.integration.modules.sys.resource.model.entity.QResource.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final SetPath<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser> users = this.<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser>createSet("users", team.sun.integration.modules.sys.user.model.entity.User.class, team.sun.integration.modules.sys.user.model.entity.QUser.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QRole(String variable) {
        this(Role.class, forVariable(variable), INITS);
    }

    public QRole(Path<? extends Role> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRole(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRole(PathMetadata metadata, PathInits inits) {
        this(Role.class, metadata, inits);
    }

    public QRole(Class<? extends Role> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creator = inits.isInitialized("creator") ? new team.sun.integration.modules.sys.user.model.entity.QUser(forProperty("creator"), inits.get("creator")) : null;
        this.creatorDepartment = inits.isInitialized("creatorDepartment") ? new team.sun.integration.modules.sys.org.model.entity.QOrg(forProperty("creatorDepartment"), inits.get("creatorDepartment")) : null;
        this.creatorTenant = inits.isInitialized("creatorTenant") ? new team.sun.integration.modules.sys.tenant.model.entity.QTenant(forProperty("creatorTenant"), inits.get("creatorTenant")) : null;
    }

}

