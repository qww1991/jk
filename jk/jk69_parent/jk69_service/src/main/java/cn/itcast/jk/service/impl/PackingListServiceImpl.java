package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

/**
 * @Description:	PackingListService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-11-16 15:22:24
 */

public class PackingListServiceImpl implements PackingListService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<PackingList> find(String hql, Class<PackingList> entityClass, Object[] params) {
		return baseDao.find(hql, PackingList.class, params);
	}

	public PackingList get(Class<PackingList> entityClass, Serializable id) {
		return (PackingList) baseDao.get(PackingList.class, id);
	}

	public Page<PackingList> findPage(String hql, Page<PackingList> page, Class<PackingList> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, PackingList.class, params);
	}

	public void saveOrUpdate(PackingList entity) {
		if(entity.getId()==null){						//代表新增
			
			entity.setState(3.0);	//3.已装箱(未提交)4.装箱完毕(待委托)
		}
		
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<PackingList> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<PackingList> entityClass, Serializable id) {
		//删除装箱单 (更新装箱单下报运单的状态)
		PackingList packingList = (PackingList) baseDao.get(PackingList.class, id);
		
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportId : exportIds) {
			Export export = (Export) baseDao.get(Export.class, exportId);
			if(UtilFuns.isNotNull(export)) {
				export.setState(2);  	//2.已报运(待装箱)
				baseDao.saveOrUpdate(export);
			}
		}
		
		baseDao.deleteById(PackingList.class, id);
	}

	public void delete(Class<PackingList> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			deleteById(entityClass,id);
		}
	}

}

