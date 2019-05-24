package daoProxy;

import conn.Conn;
import daoInterface.CompanyIn;
import daoTrue.CompanyTu;
import vo.CompanyVo;

/**
 * 代理接口类，完成对真实实现类的操作
 * @author Mr DU
 *
 */
public class CompanyPo implements CompanyIn{
	Conn conn;
	CompanyTu companyTu;
	public CompanyPo() {
		conn = new Conn();
		companyTu = new CompanyTu(conn.getConnection());
	}
	@Override
	public boolean insertCompany(CompanyVo companyVo) throws Exception {
		boolean flag = false;
		flag = companyTu.insertCompany(companyVo);
		conn.close();
		return flag;
	}
	@Override
	public boolean loginCompany(String cname, String password) throws Exception {
		boolean flag = false;
		flag = companyTu.loginCompany(cname, password);
		conn.close();
		return flag;
	}
	@Override
	public boolean updateCompany(CompanyVo companyVo,String sname) throws Exception {
		boolean flag = false;
		flag = companyTu.updateCompany(companyVo,sname);
		conn.close();
		return flag;
	}
	@Override
	public CompanyVo queryCompany(String cname) throws Exception {
		CompanyVo vo = null;
		vo  = companyTu.queryCompany(cname);
		conn.close();
		return vo;
	}
}
