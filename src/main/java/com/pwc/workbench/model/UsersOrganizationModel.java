/**
 * 
 */
package com.pwc.workbench.model;

/**
 * @author ssun206
 *
 */
public class UsersOrganizationModel {
	private Long usersId;
	private String organizationName;
	private String organizationDesc;
	private Long organizationId;
	private Long parentId;
	private String status;
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public Long getUsersId() {
		return usersId;
	}
	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationDesc() {
		return organizationDesc;
	}
	public void setOrganizationDesc(String organizationDesc) {
		this.organizationDesc = organizationDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
