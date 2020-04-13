package com.pwc.workbench.service;

import java.util.List;

import com.pwc.workbench.domain.User;
import com.pwc.workbench.model.UsersOrganizationModel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author jchen533
 *
 */
public interface UserService {
	
	public User getUserByLogin(String email, String password) throws Exception;

	public User selectByPrimaryKey(Long id) throws Exception;

	public List<UsersOrganizationModel> getUserOrg(Long id);

	public List<UsersOrganizationModel> getDomainsByUserOrg(Long usersId, Long parentId);

	public List<UsersOrganizationModel> getDepartmentTemp(Long valueOf, Long organizationId);

	public String addUser(String userName,String department,String email,String scope,String active);

	public void updateUser(String userName,String department,String email,String scope,String active,Long userId);

	public void resetPassword(Long userId);

	public List<User> getUsers(String userName);

}
