package team.sun.integration.modules.sys.config.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSecurityParam is a Querydsl query type for SecurityParam
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSecurityParam extends EntityPathBase<SecurityParam> {

    private static final long serialVersionUID = -608615810L;

    public static final QSecurityParam securityParam = new QSecurityParam("securityParam");

    public final DateTimePath<java.time.LocalDateTime> allowAccess = createDateTime("allowAccess", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> allowNotAccess = createDateTime("allowNotAccess", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath creatorDepartmentId = createString("creatorDepartmentId");

    public final StringPath creatorId = createString("creatorId");

    public final StringPath creatorTenantId = createString("creatorTenantId");

    public final ComparablePath<Character> delFlag = createComparable("delFlag", Character.class);

    public final NumberPath<Integer> faultLimit = createNumber("faultLimit", Integer.class);

    public final BooleanPath hasActive = createBoolean("hasActive");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> lockTime = createNumber("lockTime", Integer.class);

    public final NumberPath<Integer> logDataUp = createNumber("logDataUp", Integer.class);

    public final NumberPath<Integer> maxSession = createNumber("maxSession", Integer.class);

    public final StringPath modifierId = createString("modifierId");

    public final StringPath networkSegment = createString("networkSegment");

    public final NumberPath<Integer> pwdTimes = createNumber("pwdTimes", Integer.class);

    public final NumberPath<Integer> scanCycle = createNumber("scanCycle", Integer.class);

    public final NumberPath<Integer> sessionTimeout = createNumber("sessionTimeout", Integer.class);

    public final NumberPath<Integer> sleepAccount = createNumber("sleepAccount", Integer.class);

    public final NumberPath<Integer> tempAccount = createNumber("tempAccount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QSecurityParam(String variable) {
        super(SecurityParam.class, forVariable(variable));
    }

    public QSecurityParam(Path<? extends SecurityParam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSecurityParam(PathMetadata metadata) {
        super(SecurityParam.class, metadata);
    }

}

