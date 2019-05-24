package daoInterface;

import java.util.List;
import vo.AdminVo;
import vo.CjobVo;
import vo.CompanyVo;
import vo.SjobVo;
import vo.StudentVo;

/**
 * ����Աģ��
 * @author Mr DU
 *
 */
public interface AdminIn {
	/*
	 * ����Ա��¼
	 */
	public boolean loginAdmin(String name,String password) throws Exception;
	/*
	 * ����Ա�޸�
	 */
	public boolean updateAdmin(AdminVo vo,String name) throws Exception;
	/*
	 * ����ѧ����Ϣ
	 */
	public List<StudentVo> findAllStudent() throws Exception;
	/*
	 * ������ҵ��Ϣ
	 */
	public List<CompanyVo> findAllCompany() throws Exception;
	/*
	 * ������ְ��Ϣ
	 */
	public List<SjobVo> findAllSjob() throws Exception;
	/*
	 * ������Ƹ��Ϣ
	 */
	public List<CjobVo> findAllCjob() throws Exception;
}
