package com.pwc.workbench.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pwc.workbench.domain.*;
import com.pwc.workbench.service.OrganizationService;
import com.pwc.workbench.service.UserService;
import com.pwc.workbench.util.CommonUtils;
import com.pwc.workbench.util.SubjectUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * login controller
 * @author Sam Sun
 *
 */

@Api("login")
@RestController
@RequestMapping(value="/api")
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private OrganizationService organizationService;
	
	/**
	 * user login
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="login")
	@RequestMapping(value = "/login")
	@PostMapping
	@ResponseBody
	public Object login(HttpServletRequest request) throws Exception {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUserByLogin(email, password);
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(user != null){
			//get user
			List<UserMode> userModes=organizationService.getUserModes(user.getId());
           //get role
			List<RoleMode> roleModes=organizationService.getRoleModes(user.getId());

			// 防止Session Fixation攻击
			HttpSession httpSession = request.getSession();
			@SuppressWarnings("rawtypes")
			Enumeration enumeration = httpSession.getAttributeNames();
			Map<String, Object> sessionMap = new HashMap<String, Object>();
			while (enumeration.hasMoreElements()) {
				String key = (String) enumeration.nextElement();
				sessionMap.put(key, httpSession.getAttribute(key));
			}
			httpSession.invalidate();
			httpSession = request.getSession(true);
			for (String key : sessionMap.keySet()) {
				Object value = sessionMap.get(key);
				httpSession.setAttribute(key, value);
			}
			
			// 写入用户登录Session
			httpSession.setAttribute(CommonUtils.USER_ID_SESSION_NAME, String.valueOf(user.getId()));
			map.put("status",HttpStatus.OK.value());
			map.put("userModes", userModes);
			map.put("roleModes", roleModes);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}else{
			map.put("message","Invalid username/password");
			map.put("status",HttpStatus.NOT_ACCEPTABLE.value());
		}
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value="getCurrentUserName")
	@RequestMapping(value = "/getCurrentUserName", method = RequestMethod.GET)
	public @ResponseBody String getCurrentUserName() {
		return SubjectUtils.getUserName();
	}

	/**
	 * user logout
	 * @param session
	 */
	@ApiOperation(value="logout")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@CrossOrigin
	public void logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		//SecurityUtils.getSubject().logout();
	}

}
