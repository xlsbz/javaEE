package daoInterface;

import java.util.List;

import vo.CjobVo;
import vo.SjobVo;

/**
 * 完成求职表的接口
 * @author Mr DU
 *
 */
public interface StudentJobIn {
	/*
	 * 增加一份求职表
	 */
	public boolean addStudentJob(SjobVo sjobvo) throws Exception;
	/*
	 * 删除求职信
	 */
	public boolean delStudentJob(int jobid)throws Exception;
	/*
	 * 查看求职信
	 */
	public List<SjobVo> getAllSjob(String sname) throws Exception;
	/*
	 * 修改求职信
	 */
	public boolean updateStudentJob(SjobVo vo,int jobid)throws Exception;
	/*
	 * id查看求职详情
	 */
	public SjobVo findJobId(int jobid) throws Exception;
	
}
