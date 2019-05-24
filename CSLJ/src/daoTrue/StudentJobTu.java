package daoTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import daoFactory.StudentJobFy;
import daoInterface.StudentJobIn;
import vo.CjobVo;
import vo.SjobVo;

/**
 * 真实对数据操作
 * @author Mr DU
 *
 */
public class StudentJobTu implements StudentJobIn{
	private PreparedStatement prep = null;
	private Connection conn;
	public StudentJobTu(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean addStudentJob(SjobVo sjobvo) throws Exception {
		boolean flag = false;	
		String sql = "insert into tb_sjob(sname,specialty,job,emolument,ptime,atime,other) values(?,?,?,?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1,sjobvo.getSname());
		prep.setString(2,sjobvo.getSpecialty());
		prep.setString(3,sjobvo.getJob());
		prep.setString(4,sjobvo.getEmolument());
		prep.setDate(5,new Date(sjobvo.getPtime().getTime()));
		prep.setDate(6,new Date(sjobvo.getAtime().getTime()));
		prep.setString(7,sjobvo.getOther());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		prep.close();
		return flag;
	}

	@Override
	public boolean delStudentJob(int jobid) throws Exception {
		boolean flag = false;
		String sql = "delete from tb_sjob where jobid=?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, jobid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	public List<SjobVo> getAllSjob(String sname) throws Exception {
		List<SjobVo> jobs = new ArrayList<SjobVo>();
		String sql = "select jobid,sname,specialty,job,emolument,ptime,atime,other from tb_sjob where sname=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, sname);
		ResultSet rs = prep.executeQuery();
		SjobVo vo = null;
		while(rs.next()) {
			 vo =new SjobVo();
			 vo.setJobid(rs.getInt(1));
			 vo.setSname(rs.getString(2));
			 vo.setSpecialty(rs.getString(3));
			 vo.setJob(rs.getString(4));
			 vo.setEmolument(rs.getString(5));
			 vo.setPtime(rs.getDate(6));
			 vo.setAtime(rs.getDate(7));
			 vo.setOther(rs.getString(8));
			 jobs.add(vo);
		}
		prep.close();
		return jobs;
	}
	@Override
	public boolean updateStudentJob(SjobVo vo,int jobid) throws Exception {
		boolean flag = false;
		String sql = "UPDATE tb_sjob SET specialty=?,job=?,emolument=?,ptime=?,atime=?,other=? WHERE jobid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1,vo.getSpecialty());
		prep.setString(2,vo.getJob());
		prep.setString(3,vo.getEmolument());
		prep.setDate(4,new Date(vo.getPtime().getTime()));
		prep.setDate(5,new Date(vo.getAtime().getTime()));
		prep.setString(6,vo.getOther());
		prep.setInt(7, jobid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	public SjobVo findJobId(int jobid) throws Exception {
		String sql = "select jobid,sname,specialty,job,emolument,ptime,atime,other from tb_sjob where jobid=?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, jobid);
		ResultSet rs = prep.executeQuery();
		SjobVo vo = null;
		while(rs.next()) {
			 vo =new SjobVo();
			 vo.setJobid(rs.getInt(1));
			 vo.setSname(rs.getString(2));
			 vo.setSpecialty(rs.getString(3));
			 vo.setJob(rs.getString(4));
			 vo.setEmolument(rs.getString(5));
			 vo.setPtime(rs.getDate(6));
			 vo.setAtime(rs.getDate(7));
			 vo.setOther(rs.getString(8));
		}
		prep.close();
		return vo;
	}
}
