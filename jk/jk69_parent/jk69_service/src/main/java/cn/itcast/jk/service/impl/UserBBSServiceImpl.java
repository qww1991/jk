package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.UserBBS;
import cn.itcast.jk.service.UserBBSService;
import cn.itcast.util.Page;
import cn.itcast.util.UtilFuns;

public class UserBBSServiceImpl implements UserBBSService {
	private BaseDao<UserBBS> baseDao;

	public void setBaseDao(BaseDao<UserBBS> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<UserBBS> find(String hql, Class<UserBBS> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public UserBBS get(Class<UserBBS> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<UserBBS> findPage(String hql, Page<UserBBS> page, Class<UserBBS> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(UserBBS entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			String uid = UUID.randomUUID().toString();
			entity.setId(uid);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<UserBBS> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<UserBBS> entityClass, Serializable id) {
		baseDao.deleteById(UserBBS.class, id);
	}

	@Override
	public void delete(Class<UserBBS> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
