package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.service.InvoiceService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

/**
 * @Description: InvoiceService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-11-17 21:12:29
 */

public class InvoiceServiceImpl implements InvoiceService {
	// spring注入dao
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Invoice> find(String hql, Class<Invoice> entityClass, Object[] params) {
		return baseDao.find(hql, Invoice.class, params);
	}

	public Invoice get(Class<Invoice> entityClass, Serializable id) {
		return (Invoice) baseDao.get(Invoice.class, id);
	}

	public Page<Invoice> findPage(String hql, Page<Invoice> page, Class<Invoice> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Invoice.class, params);
	}

	public void saveOrUpdate(Invoice entity) {
		// 先根据对象的id去数据库查询(没查到对象,就是新增)
		Invoice invoice = (Invoice) baseDao.get(Invoice.class, entity.getId());

		if (UtilFuns.isNull(invoice)) { // 代表新增
			entity.setState(7.0);// 发票	7.已出票(未提交)8.出票成功(待进账)
			// 将发票中的委托单,委托单中的装箱单,装箱单中的报运单 状态同步
			ShippingOrder shippingOrder = (ShippingOrder) baseDao.get(ShippingOrder.class, entity.getId());
			shippingOrder.setState(7.0); // 7.已出票(未提交)8.出票成功(待进账)
			baseDao.saveOrUpdate(shippingOrder);
			// 装箱单
			PackingList packingList = (PackingList) baseDao.get(PackingList.class, shippingOrder.getId());
			packingList.setState(7.0);// 7.已出票(未提交)8.出票成功(待进账)
			//保存了发票后,将当前的时间和发票号赋值给 装箱单 中的发票号和发票日期
			packingList.setInvoiceDate(new Date());
			packingList.setInvoiceNo(entity.getScNo());
			baseDao.saveOrUpdate(packingList);
			// 所有的报运单
			String[] split = packingList.getExportIds().split(", ");
			for (String exportId : split) {
				Export export = (Export) baseDao.get(Export.class, exportId);
				export.setState(7);// 7.已出票(未提交)8.出票成功(待进账)
				baseDao.saveOrUpdate(export);
			}
		}else {	//代表修改
			//将修改后的发票信息更新到装箱单的发票信息上
			PackingList packingList = (PackingList) baseDao.get(PackingList.class, entity.getId());
			packingList.setInvoiceNo(entity.getScNo());
			baseDao.saveOrUpdate(packingList);
		}
		baseDao.saveOrUpdate(entity);

	}

	public void saveOrUpdateAll(Collection<Invoice> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Invoice> entityClass, Serializable id) {
		// 根据id删除发票(删除发票后,将委托单,委托单下装箱单 报运单状态更新 为(6.委托完毕(待出票)))
		//委托单
		ShippingOrder shippingOrder = (ShippingOrder) baseDao.get(ShippingOrder.class, id);
		if(UtilFuns.isNotNull(shippingOrder)) {
			shippingOrder.setState(6.0);	//委托完毕(待出票)
			baseDao.saveOrUpdate(shippingOrder);
			
			// 装箱单
			PackingList packingList = (PackingList) baseDao.get(PackingList.class, shippingOrder.getId());
			if (UtilFuns.isNotNull(packingList)) {
				packingList.setState(6.0); // 6.委托完毕(待出票)
				packingList.setInvoiceDate(null);	//将装箱单发票信息清空
				packingList.setInvoiceNo(null);
				baseDao.saveOrUpdate(packingList);
			}
			// 报运单
			String[] exportIds = packingList.getExportIds().split(", ");
			for (String exportId : exportIds) {
				Export export = (Export) baseDao.get(Export.class, exportId);
				if (UtilFuns.isNotNull(export)) {
					export.setState(6); // 6委托完毕(待出票)
					baseDao.saveOrUpdate(export);
				}
			}
		}
		baseDao.deleteById(Invoice.class, id);	//删除发票
	}

	
	public void delete(Class<Invoice> entityClass, Serializable[] ids) {
		
		for (Serializable id : ids) {
			deleteById(entityClass, id);
		}
		
	}

}
