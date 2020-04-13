/**
 * 
 */
package com.pwc.workbench.model;

import java.util.List;

/**
 * @author ssun206
 *
 */
public class MailByGroupModel {
	private List<String> group;
	private List<String> userName;
	private List<String> mail;
	private String deadline;
	private String period;

	
	public List<String> getGroup() {
		return group;
	}
	public void setGroup(List<String> group) {
		this.group = group;
	}
	public List<String> getMail() {
		return mail;
	}
	public void setMail(List<String> mail) {
		this.mail = mail;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public List<String> getUserName() {
		return userName;
	}
	public void setUserName(List<String> userName) {
		this.userName = userName;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
}
