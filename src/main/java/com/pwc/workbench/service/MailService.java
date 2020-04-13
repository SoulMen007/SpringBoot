package com.pwc.workbench.service;

import javax.mail.MessagingException;

/**
 * @author ssun206
 *
 */
public interface MailService {

	void sendMail(String to, String title, String content) throws MessagingException;

}
