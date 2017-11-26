package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.service.ShippingOrderService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;


public class ShippingOrderServiceImpl implements ShippingOrderService {
	//spring注入dao
	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<ShippingOrder> find(String hql, Class<ShippingOrder> entityClass, Object[] params) {
		return baseDao.find(hql, ShippingOrder.class, params);
	}

	public ShippingOrder get(Class<ShippingOrder> entityClass, Serializable id) {
		return (ShippingOrder) baseDao.get(ShippingOrder.class, id);
	}

	public Page<ShippingOrder> findPage(String hql, Page<ShippingOrder> page, Class<ShippingOrder> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, ShippingOrder.class, params);
	}

	public void saveOrUpdate(ShippingOrder entity) {
		//先根据对象的id去数据库查询(没查到对象,就是新增)
		ShippingOrder shippingOrder = (ShippingOrder) baseDao.get(ShippingOrder.class, entity.getId());
		
		if(UtilFuns.isNull(shippingOrder)) {	//代表新增
			entity.setState(5.0);//委托单 5.已委托(未提交)6.委托完毕(待出票)
			//将委托单中的装箱单,装箱单中的报运单 状态同步
			PackingList packingList = (PackingList) baseDao.get(PackingList.class, entity.getId());
			packingList.setState(5.0);//3.已装箱,待委托	 4.已委托,待出票	 5.已出票未进账 	6.已进账
			
			baseDao.saveOrUpdate(packingList);
			
			//所有的报运单
			String[] split = packingList.getExportIds().split(", ");
			for (String exportId : split) {
				Export export = (Export) baseDao.get(Export.class, exportId);
				export.setState(5);//5.已委托(未提交)6.委托完毕(待出票)
				baseDao.saveOrUpdate(export);
			}
		}
		
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<ShippingOrder> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<ShippingOrder> entityClass, Serializable id) {
		//根据id删除委托单 (删除委托单后,将委托单下装箱单 报运单状态更新 为(4.装箱完毕(待委托)))
		//装箱单
		PackingList packingList = (PackingList) baseDao.get(PackingList.class, id);
		if(UtilFuns.isNotNull(packingList)) {
			packingList.setState(4.0);	//4.装箱完毕(待委托)
			baseDao.saveOrUpdate(packingList);
		}
		//报运单
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = (Export) baseDao.get(Export.class, exportId);
			if(UtilFuns.isNotNull(export)) {
				export.setState(4);	//4.装箱完毕(待委托)
				baseDao.saveOrUpdate(export);
			}
		}
		baseDao.deleteById(ShippingOrder.class, id);
	}

	public void delete(Class<ShippingOrder> entityClass, Serializable[] ids) {
		//调用根据id删除委托单方法
		for (Serializable id : ids) {
			deleteById(entityClass, id);
		}
	}

}

