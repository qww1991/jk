package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.UserService;
import cn.itcast.util.Page;
import cn.itcast.util.SysConstant;
import cn.itcast.util.UtilFuns;

public class UserServiceImpl implements UserService {
	private BaseDao<User> baseDao;
	private JavaMailSender sender;
	private SimpleMailMessage message;
	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

	
	public void setBaseDao(BaseDao<User> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<User> find(String hql, Class<User> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public User get(Class<User> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params) {
		// TODO Auto-generated method stub
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(User entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			String uid = UUID.randomUUID().toString();
			entity.setId(uid);
			entity.getUserinfo().setId(uid);
			entity.getUserinfo().setOrderNo(0);
			Md5Hash hash=new Md5Hash(SysConstant.DEFAULT_PASS,entity.getUserName(),2);
			entity.setPassword(hash.toString());
			final String email = entity.getUserinfo().getEmail();
			final String userName = entity.getUserName();
			new Thread(new Runnable() {
				@Override
				public void run() {
					message.setTo(email);
					message.setSubject("大唐科技有限公司入职通知");
					message.setText("欢迎，"+userName+"加入我们公司"+"你默认密码为"+SysConstant.DEFAULT_PASS);
					sender.send(message);
				}
			}).start();
			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<User> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);

	}

	@Override
	public void deleteById(Class<User> entityClass, Serializable id) {
		baseDao.deleteById(User.class, id);
	}

	@Override
	public void delete(Class<User> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);

	}

}
