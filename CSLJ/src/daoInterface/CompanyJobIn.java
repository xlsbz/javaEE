package daoInterface;

import java.util.List;

import vo.CjobVo;

/**
 * 对招聘信息接口封装
 * @author Mr DU
 *
 */
public interface CompanyJobIn {
	/*
	 * 发布招聘信息
	 */
	public boolean insertJobCompany(CjobVo cjobVo) throws Exception;
	/*
	 * 修改招聘信息
	 */
	public boolean updateJobCompany(CjobVo cjobVo,int jobid) throws Exception;
	/*
	 * 删除招聘信息
	 */
	public boolean deleteJobCompany(int jobid) throws Exception;
	/*
	 * 查看发布的招聘信息
	 */
	public List<CjobVo> findJobCompany(String cname) throws Exception;
	/*
	 * id查看招聘详情
	 */
	public CjobVo findJobId(int jobid) throws Exception;

	
}
