package com.pwc.workbench.parameter;

public class ParameterListParameter {
	private String parameterName;
	private String languageKey;
	private Long parentId;
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getLanguageKey() {
		return languageKey;
	}
	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
