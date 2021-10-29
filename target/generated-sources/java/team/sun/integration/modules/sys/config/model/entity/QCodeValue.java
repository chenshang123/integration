package team.sun.integration.modules.sys.config.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeValue is a Querydsl query type for CodeValue
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeValue extends EntityPathBase<CodeValue> {

    private static final long serialVersionUID = 1772943701L;

    public static final QCodeValue codeValue = new QCodeValue("codeValue");

    public final StringPath code = createString("code");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath parentId = createString("parentId");

    public QCodeValue(String variable) {
        super(CodeValue.class, forVariable(variable));
    }

    public QCodeValue(Path<? extends CodeValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeValue(PathMetadata metadata) {
        super(CodeValue.class, metadata);
    }

}

