package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ContractServiceImpl implements ContractService {
	private BaseDao<Contract> baseDao;
	public void setBaseDao(BaseDao<Contract> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Contract> find(String hql, Class<Contract> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Contract get(Class<Contract> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Contract> findPage(String hql, Page<Contract> page, Class<Contract> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Contract entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			entity.setState(0);
			entity.setTotalAmount(0.0);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Contract> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Contract> entityClass, Serializable id) {
		baseDao.deleteById(Contract.class, id);
	}

	@Override
	public void delete(Class<Contract> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

	@Override
	public List<Contract> sqlFind(Class<Contract> entityClass,String hql) {
		List<Contract> list = baseDao.sqlFind(entityClass,hql);
		return list;
	}

}
