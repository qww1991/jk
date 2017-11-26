package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.Finance;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.service.FinanceService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

/**
 * @Description: FinanceService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-11-18 18:56:59
 */

public class FinanceServiceImpl implements FinanceService {
	// spring注入dao
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Finance> find(String hql, Class<Finance> entityClass, Object[] params) {
		return baseDao.find(hql, Finance.class, params);
	}

	public Finance get(Class<Finance> entityClass, Serializable id) {
		return (Finance) baseDao.get(Finance.class, id);
	}

	public Page<Finance> findPage(String hql, Page<Finance> page, Class<Finance> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Finance.class, params);
	}

	public void saveOrUpdate(Finance entity) {
		// 先根据对象的id去数据库查询(没查到对象,就是新增)
		Finance finance = (Finance) baseDao.get(Finance.class, entity.getId());

		if (UtilFuns.isNull(finance)) { // 代表新增
			entity.setState(9.0);// 财务报运 状态9.已进账(未提交)10.进账完毕
			entity.setInputDate(new Date());	//制单日期(当前日期)
			// 将财务报运中的发票,发票中的委托单,委托单中的装箱单,装箱单中的报运单 状态同步
			// 发票
			Invoice invoice = (Invoice) baseDao.get(Invoice.class, entity.getId());
			invoice.setState(9.0); // 9.已进账(未提交)10.进账完毕
			baseDao.saveOrUpdate(invoice);
			// 委托单
			ShippingOrder shippingOrder = (ShippingOrder) baseDao.get(ShippingOrder.class, invoice.getId());
			shippingOrder.setState(9.0); // 9.已进账(未提交)10.进账完毕
			baseDao.saveOrUpdate(shippingOrder);
			// 装箱单
			PackingList packingList = (PackingList) baseDao.get(PackingList.class, shippingOrder.getId());
			packingList.setState(9.0);// 9.已进账(未提交)10.进账完毕
			baseDao.saveOrUpdate(packingList);
			// 所有的报运单
			String[] split = packingList.getExportIds().split(", ");
			for (String exportId : split) {
				Export export = (Export) baseDao.get(Export.class, exportId);
				export.setState(9);// 9.已进账(未提交)10.进账完毕
				baseDao.saveOrUpdate(export);
			}
		}

		baseDao.saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<Finance> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Finance> entityClass, Serializable id) {
		// 根据id删除财务报运单(删除财务报运单后,将发票,发票下的委托单,委托单下装箱单 报运单状态更新 为(8.出票成功(待进账)))
		//发票
		Invoice invoice = (Invoice) baseDao.get(Invoice.class, id);
		if(UtilFuns.isNotNull(invoice)) {
			invoice.setState(8.0);	//8.出票成功(待进账)
			baseDao.saveOrUpdate(invoice);
			
			// 委托单
			ShippingOrder shippingOrder = (ShippingOrder) baseDao.get(ShippingOrder.class, invoice.getId());
			if (UtilFuns.isNotNull(shippingOrder)) {
				shippingOrder.setState(8.0);	//8.出票成功(待进账)
				baseDao.saveOrUpdate(shippingOrder);
				
				// 装箱单
				PackingList packingList = (PackingList) baseDao.get(PackingList.class, shippingOrder.getId());
				if (UtilFuns.isNotNull(packingList)) {
					packingList.setState(8.0); // 8.出票成功(待进账)
					
					baseDao.saveOrUpdate(packingList);
				}
				// 报运单
				String[] exportIds = packingList.getExportIds().split(", ");
				for (String exportId : exportIds) {
					Export export = (Export) baseDao.get(Export.class, exportId);
					if (UtilFuns.isNotNull(export)) {
						export.setState(8); // 8.出票成功(待进账)
						baseDao.saveOrUpdate(export);
					}
				}
			}
		}
		
		baseDao.deleteById(Finance.class, id); // 删除财务报运单
	}

	public void delete(Class<Finance> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			deleteById(entityClass, id);
		}
	}

}
