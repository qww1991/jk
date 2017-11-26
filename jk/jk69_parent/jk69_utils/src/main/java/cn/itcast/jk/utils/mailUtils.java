package cn.itcast.jk.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailUtils {
	/**
	 * 发送邮件工具类 ,使用时要修改该类中的公司邮箱服务器
	 * @param toaddress 接收方地址
	 * @param mailSubject 主题
	 * @param mailTest 内容
	 * @throws Exception
	 */
	public static void sendEmail(String toaddress,String mailSubject,String mailTest) throws Exception{
		Properties props=new Properties();
		//设置主机地址
		props.put("mail.smtp.host","smtp.163.com");
		//是否需要认证
		props.put("mail.smtp.auth","true");
		//实例化session(javax.mail.Session)
		Session session=Session.getInstance(props);
		//在控制台打印发送的信息、状态
		session.setDebug(true);
		//构造信息体 
		MimeMessage message =new MimeMessage(session);
		 //发件地址 （--修改处）
		Address address = new InternetAddress("apple_lzm@163.com"); 
		message.setFrom(address);
		//收件地址 
		Address toAddress = new InternetAddress(toaddress); 
		//TO 收件人  CC 抄送 
		message.setRecipient(MimeMessage.RecipientType.TO, toAddress);
		//主题 
		message.setSubject(mailSubject);
		//正文 
		message.setText(mailTest);
		message.saveChanges();
		//获取发送邮件的对象
		Transport transport = session.getTransport("smtp"); 
		//参数1：SMTP服务器 参数2：发送者邮箱 3：授权密码（--修改处）
		transport.connect("smtp.163.com", "apple_lzm@163.com", "lizhoumin0309"); //发送 
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
 
}
