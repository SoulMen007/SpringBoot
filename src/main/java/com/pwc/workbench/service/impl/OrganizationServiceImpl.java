package com.pwc.workbench.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.pwc.workbench.dao.OrganizationMapper;
import com.pwc.workbench.domain.Organization;
import com.pwc.workbench.domain.OrganizationMode;
import com.pwc.workbench.domain.RoleMode;
import com.pwc.workbench.domain.UserMode;
import com.pwc.workbench.domain.UserOrganizationRoleMode;
import com.pwc.workbench.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationMapper organizationMapper;

	@Override
	public List<Organization> listOrganization() {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrganization(Organization organization) {
		if (StringUtils.isEmpty(organization.getId())) {
			organizationMapper.insert(organization);
		} else {
			organizationMapper.updateByPrimaryKey(organization);
		}
	}

	@Override
	public Organization selectByPrimaryKey(Long id) {
		return organizationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserOrganizationRoleMode> getOrganizationsByUserId(Long userId) {
		return organizationMapper.getOrganizationsByUserId(userId);
	}

	@Override
	public List<UserMode> getUserModes(Long userId) {
		return organizationMapper.getUserModes(userId);
	}

	@Override
	public List<OrganizationMode> getOrganizationModes(Long userId) {
		return organizationMapper.getOrganizationModes(userId);
	}
	@Override
	public List<OrganizationMode> getUserOrganizationModes(Long userId) {
		return organizationMapper.getUserOrganizationModes(userId);
	}

	@Override
	public List<RoleMode> getRoleModes(Long userId) {
		return organizationMapper.getRoleModes(userId);
	}

}
