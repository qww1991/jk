package cn.itcast.jk.test;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class MailTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
//		mailUtils.sendEmail("jxb_plus@163.com", "6666", "镇流");
		ClassPathXmlApplicationContext cp= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MailSender ms= (MailSender) cp.getBean("mailSender");
		SimpleMailMessage bean = (SimpleMailMessage) cp.getBean("mailMessage");
		bean.setTo("18310013577@163.com");
		bean.setSubject("77777");
		bean.setText("gogogogo!!!!");
		ms.send(bean);
	}
}
