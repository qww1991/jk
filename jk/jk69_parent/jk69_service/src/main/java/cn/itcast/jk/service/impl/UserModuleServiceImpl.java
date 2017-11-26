package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.UserModule;
import cn.itcast.jk.service.UserModuleService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class UserModuleServiceImpl implements UserModuleService {
	private BaseDao<UserModule> baseDao;

	public void setBaseDao(BaseDao<UserModule> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<UserModule> find(String hql, Class<UserModule> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public UserModule get(Class<UserModule> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<UserModule> findPage(String hql, Page<UserModule> page, Class<UserModule> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(UserModule entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			String uid = UUID.randomUUID().toString();
			entity.setId(uid);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<UserModule> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<UserModule> entityClass, Serializable id) {
		baseDao.deleteById(UserModule.class, id);
	}

	@Override
	public void delete(Class<UserModule> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
