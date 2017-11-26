package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.util.Page;

public class DeptServiceImpl implements DeptService {
	private BaseDao<Dept> baseDao;
	

	public void setBaseDao(BaseDao<Dept> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Dept get(Class<Dept> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Dept entity) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdate(entity);

	}

	@Override
	public void saveOrUpdateAll(Collection<Dept> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Dept> entityClass, Serializable id) {
		String hql="from Dept where parent.id=?";
		List<Dept> list = this.find(hql, Dept.class, new Object[]{id});
		if(list!=null&&list.size()>0){
			for (Dept dept : list) {
				deleteById(Dept.class,dept.getId());
			}
		}
		if(this.get(Dept.class, id)!=null){
			baseDao.deleteById(Dept.class, id);
		}
		
	}

	@Override
	public void delete(Class<Dept> entityClass, Serializable[] ids) {
//		baseDao.delete(entityClass, ids);
		for (Serializable serializable : ids) {
			deleteById(Dept.class, serializable);
		}
	}

}
