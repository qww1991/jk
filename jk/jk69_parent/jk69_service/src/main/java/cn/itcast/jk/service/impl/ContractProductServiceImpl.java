package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ContractProductServiceImpl implements ContractProductService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao<ContractProduct> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ContractProduct get(Class<ContractProduct> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (ContractProduct) baseDao.get(entityClass, id);
	}

	@Override
	public Page<ContractProduct> findPage(String hql, Page<ContractProduct> page, Class<ContractProduct> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ContractProduct entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			Double subTotal;
			subTotal=entity.getCnumber()*entity.getPrice();
			entity.setAmount(subTotal);
			Contract contract = (Contract) baseDao.get(Contract.class, entity.getContract().getId());
			contract.setTotalAmount(contract.getTotalAmount()+subTotal);
		}else{
			
			Double newTotal;
			Double oldTotal;
			oldTotal = entity.getAmount();
			newTotal=entity.getCnumber()*entity.getPrice();
			entity.setAmount(newTotal);
			Contract contract = (Contract) baseDao.get(Contract.class, entity.getContract().getId());
			contract.setTotalAmount(contract.getTotalAmount()-oldTotal+newTotal);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ContractProduct> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<ContractProduct> entityClass, Serializable id) {
		//获取货物对象
		ContractProduct cproduct=(ContractProduct)baseDao.get(ContractProduct.class, id);
		//获取所有货物下的附件对象
		Set<ExtCproduct> extCproducts = cproduct.getExtCproducts();
		Double sum = cproduct.getAmount();
		for (ExtCproduct extCproduct : extCproducts) {
			Double amount = extCproduct.getAmount();
			sum+=amount;
		}
		//获取购销合同对象
		Contract contract = cproduct.getContract();
		contract.setTotalAmount(contract.getTotalAmount()-sum);
		baseDao.saveOrUpdate(contract);
		baseDao.deleteById(ContractProduct.class, id);
	}

	@Override
	public void delete(Class<ContractProduct> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
