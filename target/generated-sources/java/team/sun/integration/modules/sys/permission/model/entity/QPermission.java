package team.sun.integration.modules.sys.permission.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPermission is a Querydsl query type for Permission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPermission extends EntityPathBase<Permission> {

    private static final long serialVersionUID = 44535595L;

    public static final QPermission permission = new QPermission("permission");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final SetPath<team.sun.integration.modules.sys.resource.model.entity.Resource, team.sun.integration.modules.sys.resource.model.entity.QResource> permissionResources = this.<team.sun.integration.modules.sys.resource.model.entity.Resource, team.sun.integration.modules.sys.resource.model.entity.QResource>createSet("permissionResources", team.sun.integration.modules.sys.resource.model.entity.Resource.class, team.sun.integration.modules.sys.resource.model.entity.QResource.class, PathInits.DIRECT2);

    public final SetPath<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole> roles = this.<team.sun.integration.modules.sys.role.model.entity.Role, team.sun.integration.modules.sys.role.model.entity.QRole>createSet("roles", team.sun.integration.modules.sys.role.model.entity.Role.class, team.sun.integration.modules.sys.role.model.entity.QRole.class, PathInits.DIRECT2);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QPermission(String variable) {
        super(Permission.class, forVariable(variable));
    }

    public QPermission(Path<? extends Permission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermission(PathMetadata metadata) {
        super(Permission.class, metadata);
    }

}

