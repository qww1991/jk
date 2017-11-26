package cn.itcast.jk.test;

import java.text.ParseException;
import java.util.Date;

import cn.itcast.util.UtilFuns;

public class DateTest {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		
		String string = UtilFuns.dateTimeFormat(date);
		System.out.println(string);
		
	}
}
