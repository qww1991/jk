package cn.itcast.jk.test;

import com.alicom.dysms.api.SmsDemo;
import com.aliyuncs.exceptions.ClientException;

public class MsgDemo {
	public static void main(String[] args) throws ClientException {
		SmsDemo.sendSms("17610237097", "43654");
	}
}
