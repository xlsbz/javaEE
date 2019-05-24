package daoInterface;

import vo.CompanyVo;

/**
 * ��˾�����ӿڣ�����ʵ��
 * @author Mr DU
 *
 */
public interface CompanyIn {
	/*
	 * ʵ�ֹ�˾ע�᷽��
	 */
	public boolean insertCompany(CompanyVo companyVo) throws Exception;
	/*
	 * ʵ�ֹ�˾��¼����
	 */
	public boolean loginCompany(String cname,String password) throws Exception;
	/*
	 * ʵ�ֹ�˾��Ϣ�޸ķ���
	 */
	public boolean updateCompany(CompanyVo companyVo,String sname) throws Exception;
	/*
	 * ʵ�ֲ鿴��˾��Ϣ
	 */
	public CompanyVo queryCompany(String cname) throws Exception;
}
