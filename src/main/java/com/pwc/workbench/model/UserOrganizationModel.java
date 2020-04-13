package com.pwc.workbench.model;

public class UserOrganizationModel {
    private Long id;

    private Long userId;

    private Long groupId;
    
    private Integer posm;
    
    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getPosm() {
		return posm;
	}

	public void setPosm(Integer posm) {
		this.posm = posm;
	}
}