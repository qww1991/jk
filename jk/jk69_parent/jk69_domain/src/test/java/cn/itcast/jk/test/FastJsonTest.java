package cn.itcast.jk.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.itcast.jk.domain.Role;
import cn.itcast.jk.domain.User;

public class FastJsonTest {

	@Test
	public void testObjectToJson() {
		User user = new User();
		user.setPassword("123456");
		user.setUserName("cgx");

		String jsonString = JSON.toJSONString(user);
		System.out.println("jsonString=" + jsonString);
	}

	@Test
	public void testMapToJson() {
		Map map = new HashMap();
		map.put("userName", "cgx");
		map.put("password", 123456);

		String jsonString = JSON.toJSONString(map);
		System.out.println("jsonString=" + jsonString);
	}

	@Test
	public void testArrayToJson() {
		ArrayList list = new ArrayList();

		User user = new User();
		user.setPassword("123456");
		user.setUserName("cgx");

		User user2 = new User();
		user2.setPassword("123456");
		user2.setUserName("zbz");

		list.add(user);
		list.add(user2);

		String jsonString = JSON.toJSONString(list);
		System.out.println("jsonString=" + jsonString);
	}

	@Test
	public void testArrayToJson1(){
		ArrayList list = new ArrayList();
		
		User user = new User();
		user.setPassword("123456");
		user.setUserName("cgx");
	
		list.add(user);
		list.add(user);
		
/*		String jsonString = JSON.toJSONString(list);
		System.out.println("jsonString="+jsonString);*/
		
		String jsonString = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		System.out.println("jsonString="+jsonString);
	}
	
	/**
	 * 循环引用问题通过在要放弃的字段上标识@JSONField(serialize=false)
	 */
	@Test
	public void testArrayToJson2(){
		
		
		Role role = new Role();
		role.setName("测试经理");
		
		HashSet roles = new HashSet<Role>();
		roles.add(role);
		
		
		User user = new User();
		user.setPassword("123456");
		user.setUserName("cgx");
		user.setRoles(roles);
		
		HashSet<User> users = new HashSet<User>();
		users.add(user);
		role.setUsers(users);
		
//		PropertyPreFilter filter = new PropertyPreFilter() {
//			// 第三个参数，表示当前要转换json的属性
//			public boolean apply(JSONSerializer serializer, Object object, String name) {
//				if("users".equals(name)){
//					// 当转换到group属性的属性，不进行json的转换
//					return false;
//				}
//				return true;
//			}
//		};
		
		
		String jsonString = JSON.toJSONString(user);
		System.out.println("jsonString="+jsonString);
	}
}
