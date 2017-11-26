package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.LoginLog;
import cn.itcast.util.Page;

/**
 * @Description:	LoginLogService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-18 18:53:54
 */

public interface LoginLogService {

	public List<LoginLog> find(String hql, Class<LoginLog> entityClass, Object[] params);
	public LoginLog get(Class<LoginLog> entityClass, Serializable id);
	public Page<LoginLog> findPage(String hql, Page<LoginLog> page, Class<LoginLog> entityClass, Object[] params);
	
	public void saveOrUpdate(LoginLog entity);
	public void saveOrUpdateAll(Collection<LoginLog> entitys);
	
	public void deleteById(Class<LoginLog> entityClass, Serializable id);
	public void delete(Class<LoginLog> entityClass, Serializable[] ids);
}
