package team.sun.integration.modules.sys.log.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOperationLog is a Querydsl query type for OperationLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOperationLog extends EntityPathBase<OperationLog> {

    private static final long serialVersionUID = -202102236L;

    public static final QOperationLog operationLog = new QOperationLog("operationLog");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath createUser = createString("createUser");

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath fkMenuPageId = createString("fkMenuPageId");

    public final StringPath fkOperationId = createString("fkOperationId");

    public final StringPath fkOperationUserId = createString("fkOperationUserId");

    public final StringPath id = createString("id");

    public final StringPath methodName = createString("methodName");

    public final StringPath operation = createString("operation");

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

