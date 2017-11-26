package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.ExportProduct;
import cn.itcast.jk.service.ExportProductService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ExportProductServiceImpl implements ExportProductService{

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<ExportProduct> find(String hql, Class<ExportProduct> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ExportProduct get(Class<ExportProduct> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (ExportProduct) baseDao.get(entityClass, id);
	}

	@Override
	public Page<ExportProduct> findPage(String hql, Page<ExportProduct> page, Class<ExportProduct> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ExportProduct entity) {
		// TODO Auto-generated method stub
		if(UtilFuns.isEmpty(entity.getId())){
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ExportProduct> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<ExportProduct> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		baseDao.deleteById(entityClass, id);
		
	}

	@Override
	public void delete(Class<ExportProduct> entityClass, Serializable[] ids) {
		// TODO Auto-generated method stub
		baseDao.delete(entityClass, ids);
	}

}
