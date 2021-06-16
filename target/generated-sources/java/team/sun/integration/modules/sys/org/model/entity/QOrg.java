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

    public static final QOrg org = new QOrg("org");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> administrativeType = createNumber("administrativeType", Integer.class);

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath firstFloorId = createString("firstFloorId");

    public final SetPath<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup> groups = this.<team.sun.integration.modules.sys.group.model.entity.Group, team.sun.integration.modules.sys.group.model.entity.QGroup>createSet("groups", team.sun.integration.modules.sys.group.model.entity.Group.class, team.sun.integration.modules.sys.group.model.entity.QGroup.class, PathInits.DIRECT2);

    public final StringPath hiddenCode = createString("hiddenCode");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> layer = createNumber("layer", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath parentId = createString("parentId");

    public final StringPath profile = createString("profile");

    public final BooleanPath relationSys = createBoolean("relationSys");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final NumberPath<Integer> unitType = createNumber("unitType", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final SetPath<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser> users = this.<team.sun.integration.modules.sys.user.model.entity.User, team.sun.integration.modules.sys.user.model.entity.QUser>createSet("users", team.sun.integration.modules.sys.user.model.entity.User.class, team.sun.integration.modules.sys.user.model.entity.QUser.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QOrg(String variable) {
        super(Org.class, forVariable(variable));
    }

    public QOrg(Path<? extends Org> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrg(PathMetadata metadata) {
        super(Org.class, metadata);
    }

}

