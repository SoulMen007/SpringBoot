package com.pwc.workbench.model;

import java.util.List;

/**
 * @author ssun206
 *
 */
public class RoleMenuModel {
	
	private Long roleId;

    private String roleName;
    
    private String roleCode;
    
    private List<MenuRoleModel>  menuRole;


	public List<MenuRoleModel> getMenuRole() {
		return menuRole;
	}

	public void setMenuRole(List<MenuRoleModel> menuRole) {
		this.menuRole = menuRole;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


}
