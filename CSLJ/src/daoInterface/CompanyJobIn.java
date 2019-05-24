package daoInterface;

import java.util.List;

import vo.CjobVo;

/**
 * ����Ƹ��Ϣ�ӿڷ�װ
 * @author Mr DU
 *
 */
public interface CompanyJobIn {
	/*
	 * ������Ƹ��Ϣ
	 */
	public boolean insertJobCompany(CjobVo cjobVo) throws Exception;
	/*
	 * �޸���Ƹ��Ϣ
	 */
	public boolean updateJobCompany(CjobVo cjobVo,int jobid) throws Exception;
	/*
	 * ɾ����Ƹ��Ϣ
	 */
	public boolean deleteJobCompany(int jobid) throws Exception;
	/*
	 * �鿴��������Ƹ��Ϣ
	 */
	public List<CjobVo> findJobCompany(String cname) throws Exception;
	/*
	 * id�鿴��Ƹ����
	 */
	public CjobVo findJobId(int jobid) throws Exception;

	
}
