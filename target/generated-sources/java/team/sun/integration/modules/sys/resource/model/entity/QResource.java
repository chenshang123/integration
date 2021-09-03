package team.sun.integration.modules.sys.resource.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResource is a Querydsl query type for Resource
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = -1420791127L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResource resource = new QResource("resource");

    public final team.sun.integration.modules.sys.application.model.entity.QApplication applicationResource;

    public final StringPath component = createString("component");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final team.sun.integration.modules.sys.user.model.entity.QUser creator;

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final team.sun.integration.modules.sys.org.model.entity.QOrg department;

    public final StringPath firstFloorId = createString("firstFloorId");

    public final StringPath hiddenCode = createString("hiddenCode");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> layer = createNumber("layer", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath parentId = createString("parentId");

    public final StringPath path = createString("path");

    public final StringPath permission = createString("permission");

    public final SetPath<Element, QElement> resourceElements = this.<Element, QElement>createSet("resourceElements", Element.class, QElement.class, PathInits.DIRECT2);

    public final SetPath<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole> roles = this.<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole>createSet("roles", team.sun.integration.modules.sys.role.model.entity.Role.class, team.sun.integration.modules.sys.role.model.entity.QRole.class, PathInits.DIRECT2);

    public final SetPath<team.sun.integration.modules.sys.tenant.model.entity.Tenant, team.sun.integration.modules.sys.tenant.model.entity.QTenant> tenants = this.<team.sun.integration.modules.sys.tenant.model.entity.Tenant, team.sun.integration.modules.sys.tenant.model.entity.QTenant>createSet("tenants", team.sun.integration.modules.sys.tenant.model.entity.Tenant.class, team.sun.integration.modules.sys.tenant.model.entity.QTenant.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final EnumPath<team.sun.integration.modules.sys.resource.model.enums.ResourceType> type = createEnum("type", team.sun.integration.modules.sys.resource.model.enums.ResourceType.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public final EnumPath<team.sun.integration.modules.sys.resource.model.enums.ResourceVisitType> visitType = createEnum("visitType", team.sun.integration.modules.sys.resource.model.enums.ResourceVisitType.class);

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QResource(String variable) {
        this(Resource.class, forVariable(variable), INITS);
    }

    public QResource(Path<? extends Resource> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResource(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResource(PathMetadata metadata, PathInits inits) {
        this(Resource.class, metadata, inits);
    }

    public QResource(Class<? extends Resource> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.applicationResource = inits.isInitialized("applicationResource") ? new team.sun.integration.modules.sys.application.model.entity.QApplication(forProperty("applicationResource"), inits.get("applicationResource")) : null;
        this.creator = inits.isInitialized("creator") ? new team.sun.integration.modules.sys.user.model.entity.QUser(forProperty("creator"), inits.get("creator")) : null;
        this.department = inits.isInitialized("department") ? new team.sun.integration.modules.sys.org.model.entity.QOrg(forProperty("department")) : null;
    }

}

