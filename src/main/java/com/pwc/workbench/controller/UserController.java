package com.pwc.workbench.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.StringUtil;
import com.pwc.workbench.config.EssSettings;
import com.pwc.workbench.domain.User;
import com.pwc.workbench.model.UsersOrganizationModel;
import com.pwc.workbench.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Sam
 *
 */
@Api("users")
@RestController
@RequestMapping(value="/api")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@Resource
	private EssSettings essSettings;


	
	@RequestMapping(value = "/getUserTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getUserTest(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("UserName", "Sam");
		map.put("Department", "Oracle");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	/**
	 * 根据用户ID获取用户所属BG/部门
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getUserOrg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Object> getUserOrg(HttpServletRequest request) {
		logger.info("getUserOrg begin");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String usersId = request.getParameter("id");
			String status = request.getParameter("status");
			if (StringUtils.isEmpty(usersId)) {
				map.put("exceptionMessage", "username is empty");
				logger.error("username is empty");
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			}

			List<UsersOrganizationModel> usersOrganization = new ArrayList<UsersOrganizationModel>();
			List<UsersOrganizationModel> usersOrganizationTemp = userService.getUserOrg(Long.valueOf(usersId));
			if (StringUtil.isNotEmpty(status) && status.equals("BG")) {//如果status=BG,返回的只是BG
				for (UsersOrganizationModel obj : usersOrganizationTemp) {
					if (obj.getParentId() == null) {
						usersOrganization.add(obj);
					}
				}
			} else if (StringUtil.isNotEmpty(status) && status.equals("Department")) {//如果status=Department,返回的只是Department
				for (UsersOrganizationModel obj : usersOrganizationTemp) {
					if (obj.getParentId() != null) {//直接从result获取Department
						usersOrganization.add(obj);
					}
				}

				if (usersOrganization.size() == 0) {//如果以上没有获取到Department，执行以下部分
					for (UsersOrganizationModel obj : usersOrganizationTemp) {
						List<UsersOrganizationModel> DepartmentTemp = userService.getDepartmentTemp(Long.valueOf(usersId), obj.getOrganizationId());
						usersOrganization.addAll(DepartmentTemp);
					}
				} else {//针对获取BG下面所有部门的情况
					ArrayList list1 = new ArrayList();
					for (int i = 0; i < usersOrganization.size(); i++) {
						list1.add(usersOrganization.get(i).getOrganizationId());
					}

					for (UsersOrganizationModel obj : usersOrganizationTemp) {
						int flag = 0;
						List<UsersOrganizationModel> DepartmentTemp = userService.getDepartmentTemp(Long.valueOf(usersId), obj.getOrganizationId());
						//如果该部门已经包含在内，直接跳出for循环，
						for (UsersOrganizationModel obg1 : DepartmentTemp) {
							if (list1.contains(obg1.getOrganizationId())) {
								flag++;
								break;
							}
						}
						if (flag == 0) {//把该BG下的所有部门信息add进去
							usersOrganization.addAll(DepartmentTemp);
						}

					}
				}

			} else {//如果status为空，返回全部的organzation
				usersOrganization = usersOrganizationTemp;
				if (usersOrganizationTemp.size() > 0) {
					for (int i = 0; i < usersOrganizationTemp.size(); i++) {
						if (usersOrganizationTemp.get(i) != null) {
							List<UsersOrganizationModel> DepartmentTemp = userService.getDepartmentTemp(Long.valueOf(usersId), usersOrganizationTemp.get(i).getOrganizationId());
							usersOrganization.addAll(DepartmentTemp);
						}
					}
				}

			}
			return new ResponseEntity<Object>(usersOrganization, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exceptionMessage", "Error in getUserOrg");
			logger.error("Error in getUserOrg");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	/**
	 * 用户管理接口
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Object> getUsers(HttpServletRequest request) {
		return null;
	}

	/**
	 * 根据用户id和BG_id获取部门信息
	 *
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "get t_users_organization, t_organization, t_users by id and orgId", notes = "")
	@RequestMapping(value = "/getDepartmentByUserOrg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getDomainsByUserOrg(HttpServletRequest request) {
		logger.info("getDomainsByUserOrg begin");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String usersId = request.getParameter("userId");
			String parentId = request.getParameter("BGId");
			List<UsersOrganizationModel> usersOrganization = new ArrayList<UsersOrganizationModel>();
			if (StringUtil.isNotEmpty(usersId) && StringUtil.isNotEmpty(parentId)) {
				usersOrganization = userService.getDomainsByUserOrg(Long.valueOf(usersId), Long.valueOf(parentId));

				if (usersOrganization.size() == 0) {
					List<UsersOrganizationModel> DepartmentTemp = userService.getDepartmentTemp(Long.valueOf(usersId), Long.valueOf(parentId));
					usersOrganization.addAll(DepartmentTemp);
				}

			}
			if (StringUtil.isEmpty(usersId)) {
				usersOrganization = userService.getDomainsByUserOrg(null, Long.valueOf(parentId));
			}

			return new ResponseEntity<Object>(usersOrganization, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exceptionMessage", "Error in getDepartmentByUserOrg");
			logger.error("Error in getDepartmentByUserOrg");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	/**
	 * verificationLogin 验证用户是否处于登陆状态
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/verificationLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> verificationLogin(HttpServletRequest request) {
		logger.info("verificationLogin begin");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("status", "success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exceptionMessage", "Error in verificationLogin");
			logger.error("Error in verificationLogin");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "添加用户接口", notes = "添加用户接口")
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> addUser(@ApiParam(value = "用户名称", required = true) @RequestParam(value = "userName", required = true) String userName,
										  @ApiParam(value = "所属部门", required = true) @RequestParam(value = "department", required = true) String department,
										  @ApiParam(value = "邮箱地址", required = true) @RequestParam(value = "email", required = true) String email,
										  @ApiParam(value = "权限范围", required = true) @RequestParam(value = "scope", required = true) String scope,
										  @ApiParam(value = "活动状态", required = true) @RequestParam(value = "active", required = true) String active
	) {
		Map<String, String> map = new HashMap<>();
		try {
			String tip = userService.addUser(userName, department, email, scope, active);
			map.put("message",tip);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in addUser");
			map.put("exceptionMessage", "System Error");
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	@ApiOperation(value = "编辑用户信息", notes = "编辑用户信息")
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> editUser(@ApiParam(value = "用户名称", required = true) @RequestParam(value = "userName", required = true) String userName,
										  @ApiParam(value = "所属部门", required = true) @RequestParam(value = "department", required = true) String department,
										  @ApiParam(value = "邮箱地址", required = true) @RequestParam(value = "email", required = true) String email,
										  @ApiParam(value = "权限范围", required = true) @RequestParam(value = "scope", required = true) String scope,
										  @ApiParam(value = "userId", required = true) @RequestParam(value = "userId", required = true) Long userId,
										  @ApiParam(value = "活动状态", required = true) @RequestParam(value = "active", required = true) String active
	) {
		Map<String, String> map = new HashMap<>();
		try {
			 userService.updateUser(userName, department, email, scope, active,userId);
			 map.put("message","success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in editUser");
			map.put("exceptionMessage", "System Error");
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	@ApiOperation(value = "重置密码", notes = "重置密码")
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> resetPassword(
										  @ApiParam(value = "userId", required = true) @RequestParam(value = "userId", required = true) Long userId
	) {
		Map<String, String> map = new HashMap<>();
		try {
			userService.resetPassword(userId);
			 map.put("message","success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in resetPassword");
			map.put("exceptionMessage", "System Error");
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	@ApiOperation(value = "查询用户", notes = "查询用户")
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUsers(
										  @ApiParam(value = "userName", required = true) @RequestParam(value = "userName", required = true) String userName
	) {
		Map<String, Object> map = new HashMap<>();
		try {
			List<User> users= userService.getUsers(userName);
			 map.put("list",users);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getUsers");
			map.put("exceptionMessage", "System Error");
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}

