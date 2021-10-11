package team.sun.integration.modules.sys.config.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


/**
 * <p>
 * 系统-码值
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */
@Entity
@Table(name = "sys_code_value")
public class CodeValue implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "code_value_id")
    private String id;

    /**
     * code
     */
    private String code;
    /**
     * value
     */
    private String name;

    /**
     * 父类id
     */
    private String parentId;

    @Override
    public String toString() {
        return "CodeValue{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
