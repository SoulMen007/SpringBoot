/**
 * 
 */
package com.pwc.workbench.parameter;

/**
 * @author jchen533
 *
 */
public class BudgetOverallInquiryParameter {
	
	private Long userId;
	private Long budgetVersionId;
	private String currentStartDate;
	private String currentEndDate;
	private String lastStartDate;
	private String lastEndDate;
	private String versionYear;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBudgetVersionId() {
		return budgetVersionId;
	}
	public void setBudgetVersionId(Long budgetVersionId) {
		this.budgetVersionId = budgetVersionId;
	}
	public String getCurrentStartDate() {
		return currentStartDate;
	}
	public void setCurrentStartDate(String currentStartDate) {
		this.currentStartDate = currentStartDate;
	}
	public String getCurrentEndDate() {
		return currentEndDate;
	}
	public void setCurrentEndDate(String currentEndDate) {
		this.currentEndDate = currentEndDate;
	}
	public String getLastStartDate() {
		return lastStartDate;
	}
	public void setLastStartDate(String lastStartDate) {
		this.lastStartDate = lastStartDate;
	}
	public String getLastEndDate() {
		return lastEndDate;
	}
	public void setLastEndDate(String lastEndDate) {
		this.lastEndDate = lastEndDate;
	}
	public String getVersionYear() {
		return versionYear;
	}
	public void setVersionYear(String versionYear) {
		this.versionYear = versionYear;
	}
}
