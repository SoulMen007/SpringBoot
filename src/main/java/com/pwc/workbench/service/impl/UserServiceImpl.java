package com.pwc.workbench.service.impl;

import java.util.Date;
import java.util.List;

import com.pwc.workbench.dao.UserMapper;
import com.pwc.workbench.dao.UsersOrganizationMapper;
import com.pwc.workbench.domain.User;
import com.pwc.workbench.model.UsersOrganizationModel;
import com.pwc.workbench.service.UserService;
import com.pwc.workbench.util.CommonUtils;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UsersOrganizationMapper usersOrganizationMapper;
	
	
	

	@Override
	public User getUserByLogin(String email, String password) throws Exception {
		return userMapper.getUserByLogin(email, password);
	}

	@Override
	public User selectByPrimaryKey(Long id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<UsersOrganizationModel> getUserOrg(Long usersId) {
		return usersOrganizationMapper.getUserOrg(usersId);
	}

	

	@Override
	public List<UsersOrganizationModel> getDomainsByUserOrg(Long usersId, Long parentId) {
		return usersOrganizationMapper.getDomainsByUserOrg(usersId, parentId);
	}

	@Override
	public List<UsersOrganizationModel> getDepartmentTemp(Long valueOf, Long organizationId) {
		return null;
	}

	@Override
	public String addUser(String userName, String department, String email, String scope, String active) {
		User user = null;
		String tip = "";
		if(email != null){
			 user = userMapper.validateEmail(email);
		}
		if(user != null){
			tip = "This email address has been registered,please check again";
		}else{
			User temp = new User();
			temp.setActive(active);
			temp.setEmail(email);
			temp.setScope(scope);
			temp.setUserName(userName);
			temp.setDepartmentName(department);
			temp.setPassword("123456");
			temp.setLastUpdateDate(new Date());
			temp.setCreationDate(new Date());
			temp.setStatus("valid");
			userMapper.insertSelective(temp);

			tip = "User has been created successfully,initial password is '123456'";
		}
		return tip;
	}

	@Override
	public void updateUser(String userName, String department, String email, String scope, String active, Long userId) {

		User temp = new User();
		temp.setActive(active);
		temp.setEmail(email);
		temp.setScope(scope);
		temp.setUserName(userName);
		temp.setDepartmentName(department);
		temp.setId(userId);
		userMapper.updateByPrimaryKeySelective(temp);

	}

	@Override
	public void resetPassword(Long userId) {
		User temp = new User();
		temp.setPassword("123456");
		temp.setId(userId);
		userMapper.updateByPrimaryKeySelective(temp);
	}

	@Override
	public List<User> getUsers(String userName) {
		List<User> users=userMapper.getUsers(userName);
		return users;
	}

}
