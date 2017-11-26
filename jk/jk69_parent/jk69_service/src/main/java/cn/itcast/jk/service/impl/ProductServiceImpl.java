package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Product;
import cn.itcast.jk.service.ProductService;
import cn.itcast.util.Page;

/**
 * @Description:	ProductService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-17 21:25:17
 */

public class ProductServiceImpl implements ProductService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Product> find(String hql, Class<Product> entityClass, Object[] params) {
		return baseDao.find(hql, Product.class, params);
	}

	public Product get(Class<Product> entityClass, Serializable id) {
		
		
		return  (Product) baseDao.get(entityClass, id);
	}

	public Page<Product> findPage(String hql, Page<Product> page, Class<Product> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Product.class, params);
	}

	public void saveOrUpdate(Product entity) {
		if(entity.getId()==null){								//代表新增
			
			
			
		}
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<Product> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Product> entityClass, Serializable id) {
		baseDao.deleteById(Product.class, id);
	}

	public void delete(Class<Product> entityClass, Serializable[] ids) {
		baseDao.delete(Product.class, ids);
	}

}

