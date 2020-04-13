package com.pwc.workbench.domain;

public class Menu {
    private Long id;

    private String firstMenu;

    private String secondMenu;
    
    private String menuCode;
    private String secondMenuCode;
    private Integer menuNumber;

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

	public Integer getMenuNumber() {
		return menuNumber;
	}

	public void setMenuNumber(Integer menuNumber) {
		this.menuNumber = menuNumber;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}