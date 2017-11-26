package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.ExportProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.ExtEproduct;
import cn.itcast.jk.service.ExportService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class ExportServiceImpl implements ExportService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao<Export> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Export> find(String hql, Class<Export> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Export get(Class<Export> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (Export) baseDao.get(entityClass, id);
	}

	@Override
	public Page<Export> findPage(String hql, Page<Export> page, Class<Export> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Export entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			entity.setState(0);//0是草稿  1是上报
			entity.setInputDate(new Date());
			
			String[] cids = entity.getContractIds().split(", ");
			StringBuffer sb=new StringBuffer();
			for (String id : cids) {
				Contract contract=(Contract)baseDao.get(Contract.class, id);
				contract.setState(2);//将购销合同 修改状态为  已报运
				sb.append(contract.getContractNo());
				baseDao.saveOrUpdate(contract);
			}
			entity.setCustomerContract(sb.toString());
			
			//数据搬家
			List<ContractProduct> cplist=baseDao.find("from ContractProduct where contract.id in("+UtilFuns.joinInStr(cids)+")", ContractProduct.class, null);
			HashSet<ExportProduct> proSet = new HashSet<ExportProduct>();
			for (ContractProduct cp : cplist) {
				ExportProduct exportProduct = new ExportProduct();
				BeanUtils.copyProperties(cp, exportProduct);
				exportProduct.setId(null);
				Set<ExtCproduct> extCproducts = cp.getExtCproducts();
				HashSet<ExtEproduct> hashSet = new HashSet<ExtEproduct>();
				
				for (ExtCproduct extCproduct : extCproducts) {
					ExtEproduct extEproduct = new ExtEproduct();
					BeanUtils.copyProperties(extCproduct, extEproduct);
					extEproduct.setId(null);
					extEproduct.setExportProduct(exportProduct);
					hashSet.add(extEproduct);
				}
				exportProduct.setExtEproducts(hashSet);
				exportProduct.setExport(entity);
				proSet.add(exportProduct);
				
				
			}
			entity.setExportProducts(proSet);
			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Export> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<Export> entityClass, Serializable id) {
		baseDao.deleteById(Export.class, id);
	}

	@Override
	public void delete(Class<Export> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

	@Override
	public List<Export> sqlFind(Class<Export> entityClass,String hql) {
		List<Export> list = baseDao.sqlFind(entityClass,hql);
		return list;
	}

}
