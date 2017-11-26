package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.UserBBS;
import cn.itcast.util.Page;

public interface UserBBSService {
	//查询所有，带条件查询
	public List<UserBBS> find(String hql, Class<UserBBS> entityClass, Object[] params);
	//获取一条记录
	public UserBBS get(Class<UserBBS> entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	public Page<UserBBS> findPage(String hql, Page<UserBBS> page, Class<UserBBS> entityClass, Object[] params);
	
	//新增和修改保存
	public void saveOrUpdate(UserBBS entity);
	//批量新增和修改保存
	public void saveOrUpdateAll(Collection<UserBBS> entitys);
	
	//单条删除，按id
	public void deleteById(Class<UserBBS> entityClass, Serializable id);
	//批量删除
	public void delete(Class<UserBBS> entityClass, Serializable[] ids);
}
