package com.pwc.workbench.service;

import java.util.List;

import com.pwc.workbench.model.OrganizationBrandModel;


public interface OrganizationBrandService {
	
	public List<OrganizationBrandModel> listOrganizationBrands(Long userId);

}
