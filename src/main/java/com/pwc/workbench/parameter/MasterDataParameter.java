/**
 * 
 */
package com.pwc.workbench.parameter;

import java.util.List;

/**
 * @author jchen533
 *
 */
public class MasterDataParameter {
	
	private List<String> parameterNames;
	private String languageKey;
	public List<String> getParameterNames() {
		return parameterNames;
	}
	public void setParameterNames(List<String> parameterNames) {
		this.parameterNames = parameterNames;
	}
	public String getLanguageKey() {
		return languageKey;
	}
	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}
}
