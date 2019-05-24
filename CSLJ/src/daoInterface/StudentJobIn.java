package daoInterface;

import java.util.List;

import vo.CjobVo;
import vo.SjobVo;

/**
 * �����ְ��Ľӿ�
 * @author Mr DU
 *
 */
public interface StudentJobIn {
	/*
	 * ����һ����ְ��
	 */
	public boolean addStudentJob(SjobVo sjobvo) throws Exception;
	/*
	 * ɾ����ְ��
	 */
	public boolean delStudentJob(int jobid)throws Exception;
	/*
	 * �鿴��ְ��
	 */
	public List<SjobVo> getAllSjob(String sname) throws Exception;
	/*
	 * �޸���ְ��
	 */
	public boolean updateStudentJob(SjobVo vo,int jobid)throws Exception;
	/*
	 * id�鿴��ְ����
	 */
	public SjobVo findJobId(int jobid) throws Exception;
	
}
