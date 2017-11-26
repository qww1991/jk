package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ExtCproductServiceImpl implements ExtCproductService {
	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao<ExtCproduct> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ExtCproduct get(Class<ExtCproduct> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (ExtCproduct) baseDao.get(entityClass, id);
	}

	@Override
	public Page<ExtCproduct> findPage(String hql, Page<ExtCproduct> page, Class<ExtCproduct> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ExtCproduct entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			Double total=0.0;
			if(UtilFuns.isNotEmpty(entity.getPrice())&&UtilFuns.isNotEmpty(entity.getCnumber())){
				total=entity.getPrice()*entity.getCnumber();
			}
			entity.setAmount(total);
			ContractProduct product=(ContractProduct)baseDao.get(ContractProduct.class, entity.getContractProduct().getId());
			Contract contract = product.getContract();
			contract.setTotalAmount(contract.getTotalAmount()+total);
			baseDao.saveOrUpdate(contract);
		}else{
			Double old=entity.getAmount();
			Double newtotal=0.0;
			if(UtilFuns.isNotEmpty(entity.getPrice())&&UtilFuns.isNotEmpty(entity.getCnumber())){
				newtotal=entity.getPrice()*entity.getCnumber();
			}
			entity.setAmount(newtotal);
			ContractProduct product=(ContractProduct)baseDao.get(ContractProduct.class, entity.getContractProduct().getId());
			Contract contract = product.getContract();
			contract.setTotalAmount(contract.getTotalAmount()-old+newtotal);
			baseDao.saveOrUpdate(contract);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ExtCproduct> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<ExtCproduct> entityClass, Serializable id) {
		//获取附件对象
	ExtCproduct cproduct=(ExtCproduct)	baseDao.get(ExtCproduct.class, id);
	//获取合同对象
	ContractProduct contProduct=(ContractProduct)baseDao.get(ContractProduct.class, cproduct.getContractProduct().getId());
	Contract contract = contProduct.getContract();
	contract.setTotalAmount(contract.getTotalAmount()-cproduct.getAmount());
	baseDao.saveOrUpdate(contract);
	baseDao.deleteById(ExtCproduct.class, id);
	}

	@Override
	public void delete(Class<ExtCproduct> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
