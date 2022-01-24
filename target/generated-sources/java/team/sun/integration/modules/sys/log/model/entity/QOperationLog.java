package team.sun.integration.modules.sys.log.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOperationLog is a Querydsl query type for OperationLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOperationLog extends EntityPathBase<OperationLog> {

    private static final long serialVersionUID = -202102236L;

    public static final QOperationLog operationLog = new QOperationLog("operationLog");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath creatorDepartmentId = createString("creatorDepartmentId");

    public final StringPath creatorId = createString("creatorId");

    public final StringPath creatorTenantId = createString("creatorTenantId");

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath id = createString("id");

    public final StringPath ip = createString("ip");

    public final StringPath modifierId = createString("modifierId");

    public final StringPath name = createString("name");

    public final StringPath parameter = createString("parameter");

    public final StringPath resourceId = createString("resourceId");

    public final BooleanPath state = createBoolean("state");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QOperationLog(String variable) {
        super(OperationLog.class, forVariable(variable));
    }

    public QOperationLog(Path<? extends OperationLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOperationLog(PathMetadata metadata) {
        super(OperationLog.class, metadata);
    }

}

