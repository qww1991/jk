package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.Feedback;
import cn.itcast.util.Page;

public interface FeedbackService {
	//查询所有，带条件查询
	public List<Feedback> find(String hql, Class<Feedback> entityClass, Object[] params);
	//获取一条记录
	public Feedback get(Class<Feedback> entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	public Page<Feedback> findPage(String hql, Page<Feedback> page, Class<Feedback> entityClass, Object[] params);
	
	//新增和修改保存
	public void saveOrUpdate(Feedback entity);
	//批量新增和修改保存
	public void saveOrUpdateAll(Collection<Feedback> entitys);
	
	//单条删除，按id
	public void deleteById(Class<Feedback> entityClass, Serializable id);
	//批量删除
	public void delete(Class<Feedback> entityClass, Serializable[] ids);
	public List<Feedback> sqlFind(Class<Feedback> entityClass,String hql);
}
