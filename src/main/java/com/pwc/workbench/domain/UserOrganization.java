package com.pwc.workbench.domain;

public class UserOrganization {
    private Long id;

    private Long userId;

    private Long organizationId;
    
    private Integer posm;

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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

	public Integer getPosm() {
		return posm;
	}

	public void setPosm(Integer posm) {
		this.posm = posm;
	}
}