package cn.itcast.jk.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class MailTest {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cp= new ClassPathXmlApplicationContext("spring/applicationContext-mail.xml");
		MailSender ms= (MailSender) cp.getBean("mailSender");
		SimpleMailMessage bean = (SimpleMailMessage) cp.getBean("mailMessage");
		bean.setTo("18310013577@163.com");
		bean.setSubject("77777");
		bean.setText("gogogogo!!!!");
		ms.send(bean);
	}
}
