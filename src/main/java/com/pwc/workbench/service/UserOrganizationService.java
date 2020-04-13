/**
 * 
 */
package com.pwc.workbench.service;

import java.util.List;

import com.pwc.workbench.model.UserOrganizationModel;


public interface UserOrganizationService {
	List<UserOrganizationModel> getUserOrganization(Long userId,String authorizationType);

	boolean hasDepartmentExpenseUploadPermission(Long userId);

	boolean hasDepartmentExpenseDownloadPermission(Long userId);
}
