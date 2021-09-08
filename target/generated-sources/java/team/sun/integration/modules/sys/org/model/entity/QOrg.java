package team.sun.integration.modules.sys.org.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrg is a Querydsl query type for Org
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrg extends EntityPathBase<Org> {

    private static final long serialVersionUID = -232535651L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrg org = new QOrg("org");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> administrativeType = createNumber("administrativeType", Integer.class);

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final team.sun.integration.modules.sys.user.model.entity.QUser creator;

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final QOrg department;

    public final StringPath explain = createString("explain");

    public final StringPath firstFloorId = createString("firstFloorId");

    public final StringPath hiddenCode = createString("hiddenCode");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> layer = createNumber("layer", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath parentId = createString("parentId");

    public final BooleanPath relationSys = createBoolean("relationSys");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final team.sun.integration.modules.sys.tenant.model.entity.QTenant tenant;

    public final NumberPath<Integer> unitType = createNumber("unitType", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QOrg(String variable) {
        this(Org.class, forVariable(variable), INITS);
    }

    public QOrg(Path<? extends Org> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrg(PathMetadata metadata, PathInits inits) {
        this(Org.class, metadata, inits);
    }

    public QOrg(Class<? extends Org> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creator = inits.isInitialized("creator") ? new team.sun.integration.modules.sys.user.model.entity.QUser(forProperty("creator"), inits.get("creator")) : null;
        this.department = inits.isInitialized("department") ? new QOrg(forProperty("department"), inits.get("department")) : null;
        this.tenant = inits.isInitialized("tenant") ? new team.sun.integration.modules.sys.tenant.model.entity.QTenant(forProperty("tenant"), inits.get("tenant")) : null;
    }

}

