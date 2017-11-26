package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Module;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ModuleServiceImpl implements ModuleService {
	private BaseDao<Module> baseDao;

	public void setBaseDao(BaseDao<Module> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Module> find(String hql, Class<Module> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Module get(Class<Module> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Module> findPage(String hql, Page<Module> page, Class<Module> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Module entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			entity.setState(1);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Module> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Module> entityClass, Serializable id) {
		baseDao.deleteById(Module.class, id);
	}

	@Override
	public void delete(Class<Module> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
