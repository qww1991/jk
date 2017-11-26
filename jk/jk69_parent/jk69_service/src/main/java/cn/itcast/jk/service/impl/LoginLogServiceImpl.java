package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.LoginLog;
import cn.itcast.jk.service.LoginLogService;
import cn.itcast.util.Page;

/**
 * @Description:	LoginLogService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-18 18:53:54
 */

public class LoginLogServiceImpl implements LoginLogService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<LoginLog> find(String hql, Class<LoginLog> entityClass, Object[] params) {
		return baseDao.find(hql, LoginLog.class, params);
	}

	public LoginLog get(Class<LoginLog> entityClass, Serializable id) {
		return (LoginLog) baseDao.get(LoginLog.class, id);
	}

	public Page<LoginLog> findPage(String hql, Page<LoginLog> page, Class<LoginLog> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, LoginLog.class, params);
	}

	public void saveOrUpdate(LoginLog entity) {
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<LoginLog> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<LoginLog> entityClass, Serializable id) {
		baseDao.deleteById(LoginLog.class, id);
	}

	public void delete(Class<LoginLog> entityClass, Serializable[] ids) {
		baseDao.delete(LoginLog.class, ids);
	}

}

