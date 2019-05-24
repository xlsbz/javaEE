package com.dhr.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dhr.domain.Customer;

public class SendMail extends Thread {

	private Customer customer;

	public SendMail(Customer customer) {
		this.customer = customer;
	}

	public void run() {
		try {
			Properties props = new Properties();// key和value的参数，用于发送邮件时使用
			props.setProperty("mail.transport.protocol", "smtp");// 使用的发送协议
			props.setProperty("mail.host", "smtp.163.com");// 发件服务器地址
			props.setProperty("mail.smtp.auth", "true");// 请求认证。如果不认证，有可能不能发送邮件
			Session session = Session.getInstance(props, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("15520872886@163.com", "19980630123qaz");
				}

			});
			MimeMessage msg = new MimeMessage(session);
			// 设置邮件的头
			msg.setFrom(new InternetAddress("15520872886@163.com"));
			msg.setRecipients(RecipientType.TO, customer.getEmail());
			msg.setSubject("来自OA的激活邮件");
			// 设置邮件的内容
			msg.setContent(
					"亲爱的小伙伴：<br/>恭喜您注册成为我们的一员，请猛戳<a href='http://localhost:8081/OA/login/LoginServlet?op=active&activeCode="
							+ customer.getActiveCode() + "'>这里</a>激活您的账户。",
					"text/html;charset=UTF-8");

			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
