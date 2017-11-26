package cn.itcast.jk.action.befor;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

/**
 * @author LYY
 *
 */
public class SysbackAction extends BaseAction implements ModelDriven<User>{
	
	

	private User model = new User();
	
//	页面获取
	private String subject;
	private String backtext;
	private String[] roleIds;
	private String userid;
	private String fromemail;
	private String frompassword;
	

	//	属性注入
	private JavaMailSender sender;
	private SimpleMailMessage message;
	
	public String getSubject() {
		return subject;
	}

	public String getBacktext() {
		return backtext;
	}

	public String getFromemail() {
		return fromemail;
	}

	public String getFrompassword() {
		return frompassword;
	}


	public void setFromemail(String fromemail) {
		this.fromemail = fromemail;
	}

	public void setFrompassword(String frompassword) {
		this.frompassword = frompassword;
	}

	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}


	//	业务层
	private UserService userService;
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBacktext(String backtext) {
		this.backtext = backtext;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setModel(User model) {
		this.model = model;
	}

	@Override
	public User getModel() {
		return model;
	}
	
	
	/**
	 * 转到系统使用反馈界面
	 */
	public String tosysbackview() throws Exception {
		System.out.println("tosysbackview");
		List<User> list = userService.find("from User where state = 1 and userinfo.degree=0 ", User.class, null);
		System.out.println(list);
		super.put("userList", list);
		if(UtilFuns.isEmpty(fromemail)){
			User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
			fromemail = user.getUserinfo().getEmail();
		}
		return "tosysbackview";
	}
	
	/**
	 * 发送反馈邮件
	 */
	public String sendbackmail()  throws Exception{
		System.out.println("sendbackmail");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msgg", "");
		
		if(UtilFuns.isEmpty(userid)){
			System.out.println("adminUser为空");
			request.setAttribute("msgg", "请选择发送至哪个管理员");
			return tosysbackview();
		}
		
		User adminUser = userService.get(User.class, userid);
		String toemailAddr = adminUser.getUserinfo().getEmail();
		
		toemailAddr = adminUser.getUserinfo().getEmail();
		
		if(UtilFuns.isEmpty(toemailAddr)){
			System.out.println("toemailAddr为空");
			request.setAttribute("msgg", "该管理员没有邮箱信息");
			return tosysbackview();
		}
		
		
		System.out.println("fromemail  "+fromemail);
//		System.out.println("frompassword  "+frompassword);
//		System.out.println("toemailAddr  "+toemailAddr);
//		System.out.println(subject);
//		System.out.println(backtext);
		
		try {
			sendEmail(fromemail, frompassword, toemailAddr, subject, backtext);  //发送邮件
			System.out.println("邮件发送成功");
		} catch (Exception e) {
			System.out.println("email异常");
			request.setAttribute("msgg", "邮箱或密码不正确,邮件发送失败");
			return tosysbackview();
		}
		
		
		//短信发送模块
		User currentUser = (User) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		String telephone = adminUser.getUserinfo().getTelephone();
		String adminname = adminUser.getUserinfo().getName();
		String username = currentUser.getUserinfo().getName();
		
//		System.out.println(telephone);
//		System.out.println(adminname);
//		System.out.println(username);
		
		try {
			sendSms(telephone, adminname, username);  //发送短信
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("短信发送不成功");
		}
		//短信发送模块完
		
		
		return "sendbackmail";
	}
	
	
	//发送邮件方法，应该在service层
	public static void sendEmail(String fromaddr,String frompassword,String toaddress,String mailSubject,String mailTest) throws Exception{
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
		Address address = new InternetAddress(fromaddr); 
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
		transport.connect("smtp.163.com", fromaddr, frompassword); //发送 
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	
	
	//短信使用
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
//    static final String accessKeyId = "yourAccessKeyId";
//    static final String accessKeySecret = "yourAccessKeySecret";
    static final String accessKeyId = "LTAICp0SziqBwRVF";
    static final String accessKeySecret = "XfkZsnJegnVKDwjKNWHOWP4iyJj5om";
    //短信使用完
	
	//短信发送方法
	public static SendSmsResponse sendSms(String pnonenum,String admin,String username) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(pnonenum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("刘阳阳");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_112475028");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"456789\"}");
        String sendTest = "{\"admin\":\""+admin+"\", \"username\":\""+username+"\"}";
        request.setTemplateParam(sendTest);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }
	

}
