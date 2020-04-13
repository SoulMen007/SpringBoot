package com.pwc.workbench.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;

import com.pwc.workbench.util.CommonUtils;

/**
 * 过滤器 - 前端登陆超时验证
 * @author Sam Sun
 */
@Order(1)
@WebFilter(filterName = "LoginTimeOutFilter", urlPatterns = "/*")
public class LoginTimeOutFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//CrossOrigin
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpResponse.setHeader("Access-Control-Max-Age", "3600");
		httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Requested-With");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		//CrossOrigin
		httpResponse.setHeader("Pragma", "No-cache");
		httpResponse.setHeader("Cache-Control", "no-cache");
		httpResponse.setDateHeader("Expires", 0);
		String uri = httpRequest.getRequestURI();
		
		HttpSession session = httpRequest.getSession();
		String users = (String) session.getAttribute(CommonUtils.USER_ID_SESSION_NAME);
		
		//String queryString = httpRequest.getQueryString();
		//String loginURL = httpRequest.getContextPath();
		
		//测试环境-跨域不拦截
         chain.doFilter(request, response);

//	    正式环境-跨域拦截
//		if(uri.contains("/api")&&!uri.contains("/api/login")){
//			if(users == null){
//				String json = "{\"status\":\"406\",\"message\":\"please login\"}";
//				ServletOutputStream out = response.getOutputStream();
//	            out.write(json.getBytes());
//	            out.flush();
//	            //out.close();
//			}else{
//				chain.doFilter(request, response);
//			}
//		}else{
//			chain.doFilter(request, response);
//		}



		
	}

}
