package com.pwc.workbench.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pwc.workbench.service.MailService;

/**
 * @author ssun206
 *	邮件服务Service层
 */

@Service
public class MailServiceImpl implements MailService {

	@Autowired
    private JavaMailSender sender; //框架自带
	
    @Value("${spring.mail.username}")  //发送人的邮箱
    private String from;
    
    @Override
	public void sendMail(String to, String title, String content) throws MessagingException {
    	MimeMessage message = sender.createMimeMessage();
    	//true 表⽰示需要创建一个 multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		System.out.println("from======== "+from);
		//helper.setFrom(from); //发件人
		try {
			helper.setFrom (new InternetAddress(from, "ESS平台管理员", "UTF-8"));//自定义发件人名称
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		helper.setTo(to); //接受人
		helper.setSubject(title); //发送标题
		helper.setText(content, true);  //发送内容
        sender.send(message);
        
        System.out.println("Email send success");
	}
}
