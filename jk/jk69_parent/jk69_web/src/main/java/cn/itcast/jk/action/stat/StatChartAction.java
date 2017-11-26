package cn.itcast.jk.action.stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.hql.internal.ast.tree.FromElement;

import com.alibaba.fastjson.JSON;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Phb;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserInfo;
import cn.itcast.jk.service.LoginLogService;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.jk.service.SqlService;
import cn.itcast.jk.service.UserService;

public class StatChartAction extends BaseAction {
	private SqlService sqlService;
	

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	public String factorysale() throws Exception {
		return "factorysale";
	}
	// {
	// "country": "Lithuania",
	// "value": 260
	// }

	public String getPieData() throws Exception {
		String sql = "select factory_name,sum(cnumber) from contract_product_c group by factory_name";
		List list = sqlService.executeSQL(sql);
		List arrayList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map map = new HashMap();
			map.put("factoryName", list.get(i++));
			map.put("value", Double.parseDouble(list.get(i).toString()));
			arrayList.add(map);
		}
		String jsonString = JSON.toJSONString(arrayList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonString);

		return NONE;
	}

	public String productsale() throws Exception {
		return "productsale";
		
	}
	public String productshort() throws Exception {
		return "productshort";
	}
	public String getyzqData() throws Exception{
		System.out.println("dddd");
		String sql = "select * from(select product_no,price from product_c order by price desc) t where rownum <= 10";
		List list = sqlService.executeSQL(sql);
		
		List arrayList = new ArrayList();
		Map wmap=new HashMap();
		List xlist=new ArrayList<>();
		List ylist=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			xlist.add(list.get(i++));
			ylist.add(Double.parseDouble(list.get(i).toString()));
		}
		wmap.put("categories", xlist);
		wmap.put("data", ylist);
		String jsonString = JSON.toJSONString(wmap);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonString);
		return NONE;
	}
	// [['Shanghai', 23.7]],
	public String getcolumnData() throws Exception {
		String sql = "select * from( select contract_no,nvl(sum(total_amount),0) from contract_c group by contract_no order by nvl(sum(total_amount),0) desc) t where rownum<=15";
		List list = sqlService.executeSQL(sql);
		List arrayList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			List list1 = new ArrayList();
			list1.add(list.get(i++));
			list1.add(Double.parseDouble(list.get(i).toString()));
			arrayList.add(list1);
		}
		String jsonString = JSON.toJSONString(arrayList);
		System.out.println(jsonString);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonString);

		return NONE;
	}

	public String onlineinfo() throws Exception {
		return "onlineinfo";
	}
//	{"time":'01',"num":1}
	public String getlineData() throws Exception {
		String sql="select a1,nvl(num,0) from online_info_t t,"
				+ "( select to_char(login_time,'hh24') b1,count(*) num  "
				+ " from login_log_p group by to_char(login_time,'hh24'))h where t.a1=h.b1(+)  order by a1";
		List list = sqlService.executeSQL(sql);
		ArrayList arrayList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			HashMap map = new HashMap();
			map.put("time", list.get(i++));
			map.put("num", Double.parseDouble(list.get(i).toString()));
			arrayList.add(map);
		}
		String jsonString = JSON.toJSONString(arrayList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonString);

		return NONE;
	}
	
	
	
	public String toUserAmchars() throws Exception {
		// TODO Auto-generated method stub
		return "toUserAmchars";
	}
	
	
	
	/**
	 *[
                {
                    "name": "John",
                    "points": 35654,
                    "color": "#7F8DA9",
                    "bullet": "images/0.gif"
                },
                {
                    "name": "Damon",
                    "points": 65456,
                    "color": "#FEC514",
                    "bullet": "images/1.gif"
                },
                {
                    "name": "Patrick",
                    "points": 45724,
                    "color": "#DB4C3C",
                    "bullet": "images/2.gif"
                },
                {
                    "name": "Mark",
                    "points": 13654,
                    "color": "#DAF0FD",
                    "bullet": "images/3.gif"
                }
            ];
	 * @return
	 * @throws Exception
	 */
	public String toAmchars() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("amchars");
		String hql="select new Map(ip as name,num as points) from Phb";
		List<HashMap<String,Object>> list = baseDao.find(hql, Phb.class, null);
		String[] str={"images/0.gif","images/1.gif","images/2.gif","images/3.gif","images/0.gif","images/1.gif","images/2.gif","images/3.gif","images/0.gif","images/1.gif"};
		String[] str1={"#7F8DA9","#FEC514","#DB4C3C","#DAF0FD","#7F8DA9","#FEC514","#DB4C3C","#DAF0FD","#7F8DA9","#FEC514",};
		String s="../components/newChart/amcharts/";
		for (int i = 0; i < list.size(); i++) {
			list.get(i).put("color", str1[i]);
			list.get(i).put("bullet", s+str[i]);
		}
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json;charset=UTF-8");
		
		response.getWriter().write(jsonString);
		return NONE;
	}
	/**
	 * "country": "Poland",
        "visits": 328
	 * @return
	 * @throws Exception
	 */
	public String oldamchars() throws Exception {
		// TODO Auto-generated method stub
		String hql="select new Map(ip as country,num as visits) from Phb";
		List<HashMap<String,Object>> list = baseDao.find(hql, Phb.class, null);
		
		
		String jsonString = JSON.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json;charset=UTF-8");
		
		response.getWriter().write(jsonString);
		return NONE;
	}
	
	
	/**
	 * Echars
	 * @return
	 * @throws Exception
	 */
	public String toUserEchars() throws Exception {
		// TODO Auto-generated method stub
		return "toUserEchars";
	}
	
	/**
	 *   xAxis: [
        {
            type: 'category',
            show: false,
            data: ['Line', 'Bar', 'Scatter', 'K', 'Pie', 'Radar', 'Chord', 'Force', 'Map', 'Gauge', 'Funnel']
        }
    ], data: [12,21,10,4,12,5,6,5,25,23,7],
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public String oldtoEchar() throws Exception {
		System.out.println("toEchar");
		String hql="select new Map(ip as data,num as number) from Phb";
		List<HashMap<String,Object>> list = baseDao.find(hql, Phb.class, null);
		ArrayList ipList = new ArrayList();
		
		ArrayList numList = new ArrayList();
		HashMap map=new HashMap();
		for (int i = 0; i < list.size(); i++) {
			ipList.add(list.get(i).get("data"));
			numList.add(Double.parseDouble(list.get(i).get("number").toString()));
		}
		map.put("x", ipList);
		map.put("y", numList);
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json;charset=UTF-8");
		
		response.getWriter().write(jsonString);
		return NONE;
	}
	/**
	 *   data:['rose1','rose2','rose3','rose4','rose5','rose6','rose7','rose8']

			data:[
			                {value:10, name:'rose1'},
			                {value:5, name:'rose2'},
			                {value:15, name:'rose3'},
			                {value:25, name:'rose4'},
			                {value:20, name:'rose5'},
			                {value:35, name:'rose6'},
			                {value:30, name:'rose7'},
			                {value:40, name:'rose8'}
			            ]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public String toEchar() throws Exception {
		System.out.println("toEchar");
		String hql="select new Map(num as value,ip as name) from Phb";
		List<HashMap<String,Object>> list = baseDao.find(hql, Phb.class, null);
		
		ArrayList returnList1 = new ArrayList();
		HashMap map=new HashMap();
		for (int i = 0; i < list.size(); i++) {
			returnList1.add(list.get(i).get("name"));
			
		}
		HashMap returnMap=new HashMap();
		returnMap.put("x", list);
		returnMap.put("y", returnList1);
		
		String jsonString = JSON.toJSONString(returnMap);
		System.out.println(jsonString);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json;charset=UTF-8");
		
		response.getWriter().write(jsonString);
		return NONE;
	}
}
