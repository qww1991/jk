package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.util.Page;

/**
 * 
 * 委托单业务接口
 */

public interface ShippingOrderService {

	public List<ShippingOrder> find(String hql, Class<ShippingOrder> entityClass, Object[] params);
	public ShippingOrder get(Class<ShippingOrder> entityClass, Serializable id);
	public Page<ShippingOrder> findPage(String hql, Page<ShippingOrder> page, Class<ShippingOrder> entityClass, Object[] params);
	
	public void saveOrUpdate(ShippingOrder entity);
	public void saveOrUpdateAll(Collection<ShippingOrder> entitys);
	
	public void deleteById(Class<ShippingOrder> entityClass, Serializable id);
	public void delete(Class<ShippingOrder> entityClass, Serializable[] ids);
}
