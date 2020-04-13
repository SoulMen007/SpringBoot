package com.pwc.workbench.service;

import java.util.List;

import com.pwc.workbench.domain.Organization;
import com.pwc.workbench.domain.OrganizationMode;
import com.pwc.workbench.domain.RoleMode;
import com.pwc.workbench.domain.UserMode;
import com.pwc.workbench.domain.UserOrganizationRoleMode;

public interface OrganizationService {
	List<Organization> listOrganization();

	void saveOrganization(Organization organization);

	Organization selectByPrimaryKey(Long id);
	
	
	List<UserOrganizationRoleMode> getOrganizationsByUserId(Long userId);


	List<UserMode> getUserModes(Long id);

	List<OrganizationMode> getOrganizationModes(Long id);

	List<OrganizationMode> getUserOrganizationModes(Long id);

	List<RoleMode> getRoleModes(Long id);
}
