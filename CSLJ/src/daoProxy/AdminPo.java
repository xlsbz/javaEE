package daoProxy;

import java.util.List;

import conn.Conn;
import daoInterface.AdminIn;
import daoTrue.AdminTu;
import vo.AdminVo;
import vo.CjobVo;
import vo.CompanyVo;
import vo.SjobVo;
import vo.StudentVo;
/**
 * 管理员代理实现类
 * @author Mr DU
 *
 */
public class AdminPo implements AdminIn{
	private Conn conn;
	private AdminTu adminTu;
	public AdminPo() {
		conn = new Conn();
		adminTu = new AdminTu(conn.getConnection());
	}
	@Override
	public boolean loginAdmin(String name, String password) throws Exception {
		boolean flag = false;
		flag = adminTu.loginAdmin(name, password);
		conn.close();
		return flag;
	}

	@Override
	public boolean updateAdmin(AdminVo vo, String name) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentVo> findAllStudent() throws Exception {
		List<StudentVo> all = null;
		all = adminTu.findAllStudent();
		return all;
	}

	@Override
	public List<CompanyVo> findAllCompany() throws Exception {
		List<CompanyVo> all = null;
		all = adminTu.findAllCompany();
		conn.close();
		return all;
	}

	@Override
	public List<SjobVo> findAllSjob() throws Exception {
		List<SjobVo> all = null;
		all = adminTu.findAllSjob();
		conn.close();
		return all;
	}

	@Override
	public List<CjobVo> findAllCjob() throws Exception {
		List<CjobVo> all = null;
		all = adminTu.findAllCjob();
		conn.close();
		return all;
	}

}
