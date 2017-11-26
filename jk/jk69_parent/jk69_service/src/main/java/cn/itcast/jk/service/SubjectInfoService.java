package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.SubjectInfo;
import cn.itcast.util.Page;

public interface SubjectInfoService {
	//查询所有，带条件查询
	public List<SubjectInfo> find(String hql, Class<SubjectInfo> entityClass, Object[] params);
	//获取一条记录
	public SubjectInfo get(Class<SubjectInfo> entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	public Page<SubjectInfo> findPage(String hql, Page<SubjectInfo> page, Class<SubjectInfo> entityClass, Object[] params);
	
	//新增和修改保存
	public void saveOrUpdate(SubjectInfo entity);
	//批量新增和修改保存
	public void saveOrUpdateAll(Collection<SubjectInfo> entitys);
	
	//单条删除，按id
	public void deleteById(Class<SubjectInfo> entityClass, Serializable id);
	//批量删除
	public void delete(Class<SubjectInfo> entityClass, Serializable[] ids);
	public List<SubjectInfo> sqlFind(Class<SubjectInfo> entityClass,String hql);
}
