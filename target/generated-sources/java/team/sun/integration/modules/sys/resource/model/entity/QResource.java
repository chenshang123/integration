package team.sun.integration.modules.sys.resource.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResource is a Querydsl query type for Resource
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = -1420791127L;

    public static final QResource resource = new QResource("resource");

    public final StringPath component = createString("component");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath firstFloorId = createString("firstFloorId");

    public final StringPath hiddenCode = createString("hiddenCode");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> layer = createNumber("layer", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath parentId = createString("parentId");

    public final StringPath path = createString("path");

    public final StringPath permission = createString("permission");

    public final SetPath<team.sun.integration.modules.sys.permission.model.entity.Permission, team.sun.integration.modules.sys.permission.model.entity.QPermission> permissions = this.<team.sun.integration.modules.sys.permission.model.entity.Permission, team.sun.integration.modules.sys.permission.model.entity.QPermission>createSet("permissions", team.sun.integration.modules.sys.permission.model.entity.Permission.class, team.sun.integration.modules.sys.permission.model.entity.QPermission.class, PathInits.DIRECT2);

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QResource(String variable) {
        super(Resource.class, forVariable(variable));
    }

    public QResource(Path<? extends Resource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResource(PathMetadata metadata) {
        super(Resource.class, metadata);
    }

}

