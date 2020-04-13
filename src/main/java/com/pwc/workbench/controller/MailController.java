/**
 * 
 */
package com.pwc.workbench.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pwc.workbench.service.MailService;
import io.swagger.annotations.Api;

/**
 * @author ssun206
 *	邮件发送Controller
 */

@Api(value = "MailController")
@RestController
@RequestMapping(value = "/api")
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Resource
	private MailService mailService;
	
	@RequestMapping(value="/sendMail")
	@ResponseBody
	public String sendMail() throws MessagingException{
		System.out.println("-----mail to: test@163.com" );
		String to = "test@163.com";//接受人
		String title = "Test Mail";
		String content = "This is Test Mail.";
		mailService.sendMail(to, title, content);
        return "success";
	}
	
}
