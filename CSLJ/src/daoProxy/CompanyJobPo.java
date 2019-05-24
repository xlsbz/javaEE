package daoProxy;

import java.util.List;

import conn.Conn;
import daoInterface.CompanyIn;
import daoInterface.CompanyJobIn;
import daoTrue.CompanyJobTu;
import vo.CjobVo;
import vo.CompanyVo;

/**
 * 招聘信息代理实现类
 * @author Mr DU
 *
 */
public class CompanyJobPo implements CompanyJobIn{
	private Conn conn = null;
	private CompanyJobTu companyJobTu = null;
	public CompanyJobPo() {
		conn = new Conn();
		companyJobTu = new CompanyJobTu(conn.getConnection());
	}
	@Override
	public boolean insertJobCompany(CjobVo cjobVo) throws Exception {
		boolean flag = false;
		flag = companyJobTu.insertJobCompany(cjobVo);
		conn.close();
		return flag;
	}
	@Override
	public boolean updateJobCompany(CjobVo cjobVo, int jobid) throws Exception {
		boolean flag = false;
		flag = companyJobTu.updateJobCompany(cjobVo, jobid);
		conn.close();
		return flag;
	}
	@Override
	public boolean deleteJobCompany(int jobid) throws Exception {
		boolean flag  = false;
		flag = companyJobTu.deleteJobCompany(jobid);
		conn.close();
		return flag;
	}
	@Override
	public List<CjobVo> findJobCompany(String cname) throws Exception {
		List<CjobVo> all = null;
		all = companyJobTu.findJobCompany(cname);
		conn.close();
		return all;
	}
	@Override
	public CjobVo findJobId(int jobid) throws Exception {
		CjobVo cjobVo = null;
		cjobVo = companyJobTu.findJobId(jobid);
		return cjobVo;
	}
	
	
}
