package cn.dhr.service.impl;


import cn.dhr.dao.AdminDao;
import cn.dhr.dao.impl.AdminDaoImpl;
import cn.dhr.domain.Admin;
import cn.dhr.service.AdminService;

/**
 * ����Աʵ����
 * @author Mr DU
 *
 */
public class AdminServiceImpl implements AdminService{

	@Override
	public Admin loginAdmin(String user) {
		//����Dao
		AdminDao ad = new AdminDaoImpl();
		Admin admin = ad.loginAdmin(user);
		return admin;
	}

}
