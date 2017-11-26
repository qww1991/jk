package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.SubjectInfo;
import cn.itcast.jk.service.SubjectInfoService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class SubjectInfoServiceImpl implements SubjectInfoService {
	private BaseDao<SubjectInfo> baseDao;
	public void setBaseDao(BaseDao<SubjectInfo> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<SubjectInfo> find(String hql, Class<SubjectInfo> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public SubjectInfo get(Class<SubjectInfo> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<SubjectInfo> findPage(String hql, Page<SubjectInfo> page, Class<SubjectInfo> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(SubjectInfo entity) {
		if(UtilFuns.isEmpty(entity.getId())){
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<SubjectInfo> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<SubjectInfo> entityClass, Serializable id) {
		baseDao.deleteById(SubjectInfo.class, id);
	}

	@Override
	public void delete(Class<SubjectInfo> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

	@Override
	public List<SubjectInfo> sqlFind(Class<SubjectInfo> entityClass,String hql) {
		List<SubjectInfo> list = baseDao.sqlFind(entityClass,hql);
		return list;
	}

}
