package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.service.RoleService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class RoleServiceImpl implements RoleService {
	private BaseDao<Role> baseDao;

	public void setBaseDao(BaseDao<Role> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Role> find(String hql, Class<Role> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Role get(Class<Role> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Role> findPage(String hql, Page<Role> page, Class<Role> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Role> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Role> entityClass, Serializable id) {
		baseDao.deleteById(Role.class, id);
	}

	@Override
	public void delete(Class<Role> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
