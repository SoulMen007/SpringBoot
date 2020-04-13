package com.pwc.workbench.domain;

import java.util.Date;

public class UserOrganizationRoleMode {
    private Long userId;
    private Long groupId;
    private String userName;
    private String code;
    private String name;
    private Long  roleId;
    private String roleName;
    private Long parentId;
    private String createBy;
    private Date creationDate;
    private String lastUpdateBy;
    private Date lastUpdateDate;
    private String status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getStatus() {
        return status;
    }
}
