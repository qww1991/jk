package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.util.Page;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

public class FactoryServiceImpl implements FactoryService {
	private BaseDao<Factory> baseDao;
	
	public void setBaseDao(BaseDao<Factory> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Factory> find(String hql, Class<Factory> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Factory get(Class<Factory> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Factory> findPage(String hql, Page<Factory> page, Class<Factory> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Factory entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			String uuid = UUID.randomUUID().toString();
			entity.setId(uuid);
			entity.setCreateTime(new Date(System.currentTimeMillis()));
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User) session.getAttribute(SysConstant.CURRENT_USER_INFO);
			entity.setCreateDept(user.getDept().getId());
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Factory> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Factory> entityClass, Serializable id) {
		baseDao.deleteById(Factory.class, id);
	}

	@Override
	public void delete(Class<Factory> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
