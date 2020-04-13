package com.pwc.workbench.model;

/**
 * @author ssun206
 *
 */
public class MenuRoleModel {
	private Long menuId;
	private String firstMenu;
	private String secondMenu;
	private Long roleId;
	private String accessType;
	private String menuCode;
	private String secondMenuCode;
	private Long menuNumber;
	private String allMenuCodes;
	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getMenuNumber() {
		return menuNumber;
	}
	public void setMenuNumber(Long menuNumber) {
		this.menuNumber = menuNumber;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getSecondMenuCode() {
		return secondMenuCode;
	}
	public void setSecondMenuCode(String secondMenuCode) {
		this.secondMenuCode = secondMenuCode;
	}
	public String getFirstMenu() {
		return firstMenu;
	}
	public void setFirstMenu(String firstMenu) {
		this.firstMenu = firstMenu;
	}
	public String getSecondMenu() {
		return secondMenu;
	}
	public void setSecondMenu(String secondMenu) {
		this.secondMenu = secondMenu;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getAllMenuCodes() {
		return allMenuCodes;
	}
	public void setAllMenuCodes(String allMenuCodes) {
		this.allMenuCodes = allMenuCodes;
	}
	
}
