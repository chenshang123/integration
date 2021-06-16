package team.sun.integration.modules.sys.log.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Entity
@Table(name = "sys_operation_log")
public class OperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 操作业务id
     */
    private String fkOperationId;

    /**
     * 用户id
     */
    private String fkOperationUserId;

    /**
     * 管理菜单页面id
     */
    private String fkMenuPageId;

    /**
     * 操作内容
     */
    @Column(name = "operation")
    private String operation;

    /**
     * 操作名称
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 操作内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 操作人员
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 操作状态 0失败 1成功
     */
    @Column(name = "state")
    private Boolean state;

    /**
     * 日志类型： 0 系统日志 1业务日志  2 异常事件
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateTime;

    /**
     * 0正常 1删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkOperationId() {
        return fkOperationId;
    }

    public void setFkOperationId(String fkOperationId) {
        this.fkOperationId = fkOperationId;
    }

    public String getFkOperationUserId() {
        return fkOperationUserId;
    }

    public void setFkOperationUserId(String fkOperationUserId) {
        this.fkOperationUserId = fkOperationUserId;
    }

    public String getFkMenuPageId() {
        return fkMenuPageId;
    }

    public void setFkMenuPageId(String fkMenuPageId) {
        this.fkMenuPageId = fkMenuPageId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
