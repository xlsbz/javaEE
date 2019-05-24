package daoTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import daoInterface.CompanyJobIn;
import vo.CjobVo;

/**
 * 实现招聘信息的真实类
 * @author Mr DU
 *
 */
public class CompanyJobTu implements CompanyJobIn{
	private Connection conn = null;
	private PreparedStatement prep = null;
	public CompanyJobTu(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean insertJobCompany(CjobVo vo) throws Exception {
		boolean flag =false;
		String sql = "INSERT INTO tb_cjob(cname,specialty,job,emolument,ptime,atime,other) value(?,?,?,?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1,vo.getCname());
		prep.setString(2, vo.getSpecialty());
		prep.setString(3, vo.getJob());
		prep.setString(4, vo.getEmolument());
		prep.setDate(5,new Date(vo.getPtime().getTime()));
		prep.setDate(6, new Date(vo.getAtime().getTime()));
		prep.setString(7, vo.getOther());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteJobCompany(int jobid) throws Exception {
		boolean flag = false;
		String sql  ="DELETE FROM tb_cjob WHERE jobid=?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, jobid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	public List<CjobVo> findJobCompany(String cname) throws Exception {
		List<CjobVo> all = new ArrayList<CjobVo>();
		String sql = "SELECT jobid,cname,specialty,job,emolument,ptime,atime,other FROM tb_cjob where cname=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cname);
		ResultSet rs = null;
		CjobVo vo = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			vo = new CjobVo();
			vo.setJobid(rs.getInt(1));
			vo.setCname(rs.getString(2));
			vo.setSpecialty(rs.getString(3));
			vo.setJob(rs.getString(4));
			vo.setEmolument(rs.getString(5));
			vo.setPtime(rs.getDate(6));
			vo.setAtime(rs.getDate(7));
			vo.setOther(rs.getString(8));
			all.add(vo);
		}
		return all;
	}
	@Override
	public boolean updateJobCompany(CjobVo vo, int jobid) throws Exception {
		boolean flag =false;
		String sql = "UPDATE tb_cjob SET cname=?,specialty=?,job=?,emolument=?,ptime=?,atime=?,other=? WHERE jobid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1,vo.getCname());
		prep.setString(2, vo.getSpecialty());
		prep.setString(3, vo.getJob());
		prep.setString(4, vo.getEmolument());
		prep.setDate(5,new Date(vo.getPtime().getTime()));
		prep.setDate(6, new Date(vo.getAtime().getTime()));
		prep.setString(7, vo.getOther());
		prep.setInt(8, jobid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	public CjobVo findJobId(int jobid) throws Exception {
		String sql = "SELECT jobid,cname,specialty,job,emolument,ptime,atime,other FROM tb_cjob where jobid=?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, jobid);
		ResultSet rs = null;
		CjobVo vo = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			vo = new CjobVo();
			vo.setJobid(rs.getInt(1));
			vo.setCname(rs.getString(2));
			vo.setSpecialty(rs.getString(3));
			vo.setJob(rs.getString(4));
			vo.setEmolument(rs.getString(5));
			vo.setPtime(rs.getDate(6));
			vo.setAtime(rs.getDate(7));
			vo.setOther(rs.getString(8));
		}
		return vo;
	}
	
}
