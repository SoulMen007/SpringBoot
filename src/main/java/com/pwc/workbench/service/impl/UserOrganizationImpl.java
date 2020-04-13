/**
 * 
 */
package com.pwc.workbench.service.impl;

import com.pwc.workbench.dao.UserOrganizationMapper;
import com.pwc.workbench.model.UserOrganizationModel;
import com.pwc.workbench.service.UserOrganizationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jchen533
 *
 */
@Service
public class UserOrganizationImpl implements UserOrganizationService {

	@Autowired
	private UserOrganizationMapper userOrganizationMapper;

	@Override
	public List<UserOrganizationModel> getUserOrganization(Long userId,String authorizationType) {
		return userOrganizationMapper.getUserOrganization(userId,authorizationType);
	}

	@Override
	public boolean hasDepartmentExpenseUploadPermission(Long userId) {
		return userOrganizationMapper.selectIfHasUploadPermission(userId);
	}

	@Override
	public boolean hasDepartmentExpenseDownloadPermission(Long userId) {
		return userOrganizationMapper.selectIfHasDownloadPermission(userId);
	}


}
