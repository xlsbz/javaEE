package daoTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import daoInterface.AdminIn;
import vo.AdminVo;
import vo.CjobVo;
import vo.CompanyVo;
import vo.SjobVo;
import vo.StudentVo;
/**
 * 管理员真实实现类
 * @author Mr DU
 *
 */
public class AdminTu implements AdminIn{
	private PreparedStatement prep = null;
	private Connection conn = null;
	public AdminTu(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean loginAdmin(String name, String password) throws Exception {
		boolean flag = false;
		String sql = "SELECT id,name,password FROM tb_admin WHERE name=? and password=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, name);
		prep.setString(2, password);
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateAdmin(AdminVo vo, String name) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentVo> findAllStudent() throws Exception {
		List<StudentVo> all = new ArrayList<>();
		StudentVo studentVo = null;
		String sql = "SELECT sname,password,name,age,sex,birthday,school,specialty,knowledge,email,resume FROM tb_student";
		prep = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			studentVo = new StudentVo();
			studentVo.setSname(rs.getString(1));
			studentVo.setPassword(rs.getString(2));
			studentVo.setName(rs.getString(3));
			studentVo.setAge(rs.getInt(4));
			studentVo.setSex(rs.getString(5));
			studentVo.setBirthday(rs.getDate(6));
			studentVo.setSchool(rs.getString(7));
			studentVo.setSpecialty(rs.getString(8));
			studentVo.setKnowledge(rs.getString(9));
			studentVo.setEmail(rs.getString(10));
			studentVo.setResume(rs.getString(11));
			all.add(studentVo);
		}
		return all;
	}

	@Override
	public List<CompanyVo> findAllCompany() throws Exception {
		List<CompanyVo> all = new ArrayList<>();
		CompanyVo companyVo = null;
		String sql = "SELECT cname,password,name,email,tel,manage,address,resume FROM tb_company";
		prep = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			companyVo = new CompanyVo();
			companyVo.setCname(rs.getString(1));
			companyVo.setPassword(rs.getString(2));
			companyVo.setName(rs.getString(3));
			companyVo.setEmail(rs.getString(4));
			companyVo.setTel(rs.getString(5));
			companyVo.setManage(rs.getString(6));
			companyVo.setAddress(rs.getString(7));
			companyVo.setResume(rs.getString(8));
			all.add(companyVo);
		}
		return all;
	}

	@Override
	public List<SjobVo> findAllSjob() throws Exception {
		List<SjobVo> all = new ArrayList<>();
		SjobVo sjobVo = null;
		String sql = "SELECT jobid,sname,specialty,job,emolument,ptime,atime,other FROM tb_sjob";
		prep = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			sjobVo = new SjobVo();
			sjobVo.setJobid(rs.getInt(1));
			sjobVo.setSname(rs.getString(2));
			sjobVo.setSpecialty(rs.getString(3));
			sjobVo.setJob(rs.getString(4));
			sjobVo.setEmolument(rs.getString(5));
			sjobVo.setPtime(rs.getDate(6));
			sjobVo.setAtime(rs.getDate(7));
			sjobVo.setOther(rs.getString(8));
			all.add(sjobVo);
		}
		return all;
	}

	@Override
	public List<CjobVo> findAllCjob() throws Exception {
		List<CjobVo> all = new ArrayList<>();
		CjobVo cjobVo = null;
		String sql = "SELECT jobid,cname,specialty,job,emolument,ptime,atime,other FROM tb_cjob";
		prep = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			cjobVo = new CjobVo();
			cjobVo.setJobid(rs.getInt(1));
			cjobVo.setCname(rs.getString(2));
			cjobVo.setSpecialty(rs.getString(3));
			cjobVo.setJob(rs.getString(4));
			cjobVo.setEmolument(rs.getString(5));
			cjobVo.setPtime(rs.getDate(6));
			cjobVo.setAtime(rs.getDate(7));
			cjobVo.setOther(rs.getString(8));
			all.add(cjobVo);
		}
		return all;
	}

}
