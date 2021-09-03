package team.sun.integration.modules.sys.log.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOperationLog is a Querydsl query type for OperationLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOperationLog extends EntityPathBase<OperationLog> {

    private static final long serialVersionUID = -202102236L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOperationLog operationLog = new QOperationLog("operationLog");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final team.sun.integration.modules.sys.user.model.entity.QUser creator;

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final team.sun.integration.modules.sys.org.model.entity.QOrg department;

    public final StringPath id = createString("id");

    public final StringPath ip = createString("ip");

    public final StringPath name = createString("name");

    public final StringPath parameter = createString("parameter");

    public final StringPath resourceId = createString("resourceId");

    public final BooleanPath state = createBoolean("state");

    public final team.sun.integration.modules.sys.tenant.model.entity.QTenant tenant;

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QOperationLog(String variable) {
        this(OperationLog.class, forVariable(variable), INITS);
    }

    public QOperationLog(Path<? extends OperationLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOperationLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOperationLog(PathMetadata metadata, PathInits inits) {
        this(OperationLog.class, metadata, inits);
    }

    public QOperationLog(Class<? extends OperationLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.creator = inits.isInitialized("creator") ? new team.sun.integration.modules.sys.user.model.entity.QUser(forProperty("creator"), inits.get("creator")) : null;
        this.department = inits.isInitialized("department") ? new team.sun.integration.modules.sys.org.model.entity.QOrg(forProperty("department")) : null;
        this.tenant = inits.isInitialized("tenant") ? new team.sun.integration.modules.sys.tenant.model.entity.QTenant(forProperty("tenant"), inits.get("tenant")) : null;
    }

}

