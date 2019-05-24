package daoProxy;

import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import daoInterface.StudentJobIn;
import daoTrue.StudentJobTu;
import vo.CjobVo;
import vo.SjobVo;
/**
 * 代理接口完成操作
 * @author Mr DU
 *
 */
public class StudentJobPo implements StudentJobIn{
	private Conn conn;
	private StudentJobTu jobtu;
	public StudentJobPo() {
		conn = new Conn();
		jobtu = new StudentJobTu(conn.getConnection());
	}
	@Override
	public boolean addStudentJob(SjobVo sjobvo) throws Exception {
		boolean flag = jobtu.addStudentJob(sjobvo);
		conn.close();
		return flag;
	}

	@Override
	public boolean delStudentJob(int jobid) throws Exception {
		boolean flag = false;
		flag = jobtu.delStudentJob(jobid);
		conn.close();
		return flag;
	}
	@Override
	public List<SjobVo> getAllSjob(String sname) throws Exception {
		List<SjobVo> jobs = null;
		jobs = jobtu.getAllSjob(sname);
		conn.close();
		return jobs;
	}
	@Override
	public boolean updateStudentJob(SjobVo vo, int jobid) throws Exception {
		boolean flag = false;
		flag = jobtu.updateStudentJob(vo, jobid);
		conn.close();
		return flag;
	}
	@Override
	public SjobVo findJobId(int jobid) throws Exception {
		SjobVo sjobVo = null;
		sjobVo = jobtu.findJobId(jobid);
		conn.close();
		return sjobVo;
	}

}
