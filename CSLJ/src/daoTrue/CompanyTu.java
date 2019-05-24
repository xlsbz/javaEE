package daoTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import daoInterface.CompanyIn;
import vo.CompanyVo;

/**
 * 真实实现类  完成对公司表的操作
 * @author Mr DU
 *
 */
public class CompanyTu implements CompanyIn{
	private PreparedStatement prep = null;
	private Connection conn = null;
	public CompanyTu(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean insertCompany(CompanyVo companyVo) throws Exception {
		boolean flag = false;
		String sql = "insert into tb_company(cname,password,name,email,tel,manage,address,resume)values(?,?,?,?,?,?,?,?)";
		this.prep = this.conn.prepareStatement(sql);
		prep.setString(1, companyVo.getCname());
		prep.setString(2, companyVo.getPassword());
		prep.setString(3, companyVo.getName());
		prep.setString(4, companyVo.getEmail());
		prep.setString(5, companyVo.getTel());
		prep.setString(6, companyVo.getManage());
		prep.setString(7, companyVo.getAddress());
		prep.setString(8, companyVo.getResume());
		if(prep.executeUpdate()>0) {
			flag = true;
			
		}
		return flag;
	}

	@Override
	public boolean loginCompany(String cname, String password) throws Exception {
		boolean flag = false;
		String sql = "select cname,name from tb_company where cname=? and password=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cname);
		prep.setString(2, password);
		ResultSet rs =null;
		rs = prep.executeQuery();
		if(rs.next()) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateCompany(CompanyVo companyVo,String cname) throws Exception {
		boolean flag = false;
		String sql = "update tb_company set cname=?,password=?,name=?,email=?,tel=?,manage=?,address=?,resume=? where cname=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, companyVo.getCname());
		prep.setString(2, companyVo.getPassword());
		prep.setString(3, companyVo.getName());
		prep.setString(4, companyVo.getEmail());
		prep.setString(5, companyVo.getTel());
		prep.setString(6, companyVo.getManage());
		prep.setString(7, companyVo.getAddress());
		prep.setString(8, companyVo.getResume());
		prep.setString(9, cname);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	public CompanyVo queryCompany(String cname) throws Exception {
		CompanyVo vo = new CompanyVo();
		String sql = "select cname,password,name,email,tel,manage,address,resume from tb_company where cname=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cname);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			vo.setCname(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setEmail(rs.getString(4));
			vo.setTel(rs.getString(5));
			vo.setManage(rs.getString(6));
			vo.setAddress(rs.getString(7));
			vo.setResume(rs.getString(8));
		}
		return vo;
	}

}
