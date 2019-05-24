package daoInterface;

import java.util.List;
import vo.AdminVo;
import vo.CjobVo;
import vo.CompanyVo;
import vo.SjobVo;
import vo.StudentVo;

/**
 * 管理员模块
 * @author Mr DU
 *
 */
public interface AdminIn {
	/*
	 * 管理员登录
	 */
	public boolean loginAdmin(String name,String password) throws Exception;
	/*
	 * 管理员修改
	 */
	public boolean updateAdmin(AdminVo vo,String name) throws Exception;
	/*
	 * 管理学生信息
	 */
	public List<StudentVo> findAllStudent() throws Exception;
	/*
	 * 管理企业信息
	 */
	public List<CompanyVo> findAllCompany() throws Exception;
	/*
	 * 管理求职信息
	 */
	public List<SjobVo> findAllSjob() throws Exception;
	/*
	 * 管理招聘信息
	 */
	public List<CjobVo> findAllCjob() throws Exception;
}
