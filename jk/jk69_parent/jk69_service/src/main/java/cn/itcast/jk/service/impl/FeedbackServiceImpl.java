package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Feedback;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserInfo;
import cn.itcast.jk.service.FeedbackService;
import cn.itcast.util.Page;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

public class FeedbackServiceImpl implements FeedbackService {
	private BaseDao<Feedback> baseDao;
	public void setBaseDao(BaseDao<Feedback> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Feedback> find(String hql, Class<Feedback> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Feedback get(Class<Feedback> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Feedback> findPage(String hql, Page<Feedback> page, Class<Feedback> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Feedback entity) {
		if(UtilFuns.isEmpty(entity.getId())){
//			String id = UUID.randomUUID().toString();
//			entity.setId(id);
			//发送时间
			
			entity.setCreateTime(new Date(System.currentTimeMillis()));
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User) session.getAttribute(SysConstant.CURRENT_USER_INFO);
			UserInfo userinfo = user.getUserinfo();
			//创建人
			entity.setAnswerBy(userinfo.getName());
			//创建人部门ID
			entity.setCreateDept(user.getDept().getId());
			//创建人ID
			entity.setCreateBy(userinfo.getId());
			//创建人手机
			entity.setTelephone(userinfo.getTelephone());
			//默认状态
			entity.setState(0);
			//难易程度
			
			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Feedback> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Feedback> entityClass, Serializable id) {
		baseDao.deleteById(Feedback.class, id);
	}

	@Override
	public void delete(Class<Feedback> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

	@Override
	public List<Feedback> sqlFind(Class<Feedback> entityClass,String hql) {
		List<Feedback> list = baseDao.sqlFind(entityClass,hql);
		return list;
	}

}
