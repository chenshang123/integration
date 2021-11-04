package team.sun.integration.modules.sys.user.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1411386141L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final DateTimePath<java.time.LocalDateTime> allowAccess = createDateTime("allowAccess", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> allowNotAccess = createDateTime("allowNotAccess", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final StringPath creatorDepartmentId = createString("creatorDepartmentId");

    public final StringPath creatorId = createString("creatorId");

    public final StringPath creatorTenantId = createString("creatorTenantId");

    public final NumberPath<Integer> dataAuthorityType = createNumber("dataAuthorityType", Integer.class);

    public final ComparablePath<Character> delFlag = createComparable("delFlag", Character.class);

    public final StringPath email = createString("email");

    public final StringPath faceImg = createString("faceImg");

    public final BooleanPath gender = createBoolean("gender");

    public final StringPath icCard = createString("icCard");

    public final StringPath id = createString("id");

    public final BooleanPath initType = createBoolean("initType");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateTime = createDateTime("lastUpdateTime", java.time.LocalDateTime.class);

    public final BooleanPath locked = createBoolean("locked");

    public final DateTimePath<java.time.LocalDateTime> lockTime = createDateTime("lockTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> loginFail = createNumber("loginFail", Integer.class);

    public final StringPath loginIp = createString("loginIp");

    public final StringPath modifierId = createString("modifierId");

    public final StringPath petImg = createString("petImg");

    public final StringPath petName = createString("petName");

    public final StringPath phone = createString("phone");

    public final StringPath pwd = createString("pwd");

    public final StringPath salt = createString("salt");

    public final DateTimePath<java.time.LocalDateTime> sleepTime = createDateTime("sleepTime", java.time.LocalDateTime.class);

    public final BooleanPath state = createBoolean("state");

    public final BooleanPath unitType = createBoolean("unitType");

    public final DateTimePath<java.time.LocalDateTime> updatePwdTime = createDateTime("updatePwdTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final SetPath<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup> userGroups = this.<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup>createSet("userGroups", team.sun.integration.modules.sys.group.model.entity.Group.class, team.sun.integration.modules.sys.group.model.entity.QGroup.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public final team.sun.integration.modules.sys.org.model.entity.QOrg userOrg;

    public final SetPath<team.sun.integration.modules.sys.position.model.entity.Position, team.sun.integration.modules.sys.position.model.entity.QPosition> userPositions = this.<team.sun.integration.modules.sys.position.model.entity.Position, team.sun.integration.modules.sys.position.model.entity.QPosition>createSet("userPositions", team.sun.integration.modules.sys.position.model.entity.Position.class, team.sun.integration.modules.sys.position.model.entity.QPosition.class, PathInits.DIRECT2);

    public final SetPath<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole> userRoles = this.<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole>createSet("userRoles", team.sun.integration.modules.sys.role.model.entity.Role.class, team.sun.integration.modules.sys.role.model.entity.QRole.class, PathInits.DIRECT2);

    public final NumberPath<Integer> userType = createNumber("userType", Integer.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userOrg = inits.isInitialized("userOrg") ? new team.sun.integration.modules.sys.org.model.entity.QOrg(forProperty("userOrg")) : null;
    }

}

