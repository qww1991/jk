package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.Product;
import cn.itcast.util.Page;

/**
 * @Description:	ProductService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-17 21:25:17
 */

public interface ProductService {

	public List<Product> find(String hql, Class<Product> entityClass, Object[] params);
	public Product get(Class<Product> entityClass, Serializable id);
	public Page<Product> findPage(String hql, Page<Product> page, Class<Product> entityClass, Object[] params);
	
	public void saveOrUpdate(Product entity);
	public void saveOrUpdateAll(Collection<Product> entitys);
	
	public void deleteById(Class<Product> entityClass, Serializable id);
	public void delete(Class<Product> entityClass, Serializable[] ids);
}
