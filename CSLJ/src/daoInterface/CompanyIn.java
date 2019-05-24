package daoInterface;

import vo.CompanyVo;

/**
 * 公司操作接口，子类实现
 * @author Mr DU
 *
 */
public interface CompanyIn {
	/*
	 * 实现公司注册方法
	 */
	public boolean insertCompany(CompanyVo companyVo) throws Exception;
	/*
	 * 实现公司登录方法
	 */
	public boolean loginCompany(String cname,String password) throws Exception;
	/*
	 * 实现公司信息修改方法
	 */
	public boolean updateCompany(CompanyVo companyVo,String sname) throws Exception;
	/*
	 * 实现查看公司信息
	 */
	public CompanyVo queryCompany(String cname) throws Exception;
}
