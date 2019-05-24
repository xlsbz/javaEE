package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.CompanyJobFy;
import vo.CjobVo;

/**
 * 实现发布招聘信息的控制器
 * @author Mr DU
 * 本控制器采用注解方式，所以无需配置xml
 */
@WebServlet("/company/CompanyJobS")
public class CompanyJobS extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		switch(option) {
		case "insert_companyjob":
			try {
				insertCompanyJob(req, res);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "getAll_jobs":
			findCompanyJob(req,res);
			break;
		case "delete_companyjob":
				deleteCompanyJob(req, res);
			break;
		case "to_update":
			toupdate(req,res);
			break;
		case "update_companyjob":
			try {
				updateCompanyJob(req, res);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	/*
	 * 处理发布招聘信息
	 */
	public void insertCompanyJob(HttpServletRequest req,HttpServletResponse res) 
			throws ParseException, ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String cname = req.getParameter("cname");
		String specialty = req.getParameter("specialty");
		String job = req.getParameter("job");
		String emolument = req.getParameter("emolument");
		Date ptime = dateFormat.parse(req.getParameter("ptime"));
		Date atime = dateFormat.parse(req.getParameter("atime"));
		String other = req.getParameter("other");
		CjobVo vo = new CjobVo(cname, specialty, job, emolument, ptime, atime, other);
		boolean flag = false;
		try {
			flag = CompanyJobFy.getCompanyJobFy().insertJobCompany(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			req.setAttribute("insertjob_success", "招聘信息增加成功");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}
	}
	/*
	 * 处理删除招聘
	 */
	public void deleteCompanyJob(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException  {
		int jobid = 0 ;
		boolean flag = false;
		try {
			jobid = Integer.parseInt(req.getParameter("jobid"));
			flag = CompanyJobFy.getCompanyJobFy().deleteJobCompany(jobid);		
		} catch (Exception e) {
			req.setAttribute("msg_del", "删除失败，您没有选择数据");
			req.getRequestDispatcher("success.jsp").forward(req, res);	
			e.printStackTrace();
		}
		if(flag) {
			req.setAttribute("del_success", "编号"+jobid+"删除成功");
			req.getRequestDispatcher("success.jsp").forward(req, res);	
		}
	}
	/**
	 * 通往修改
	 * @param req
	 * @param res
	 * @throws ParseException
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toupdate(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		CjobVo vo = null;
		try {
			vo = CompanyJobFy.getCompanyJobFy().findJobId(jobid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("update_job", vo);
		req.getRequestDispatcher("update_companyjob.jsp").forward(req, res);
	}
	/*
	 * 处理修改招聘信息
	 */
	public void updateCompanyJob(HttpServletRequest req,HttpServletResponse res) 
			throws ParseException, ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String cname = req.getParameter("cname");
		String specialty = req.getParameter("specialty");
		String job = req.getParameter("job");
		String emolument = req.getParameter("emolument");
		Date ptime = dateFormat.parse(req.getParameter("ptime"));
		Date atime = dateFormat.parse(req.getParameter("atime"));
		String other = req.getParameter("other");
		CjobVo vo = new CjobVo(cname, specialty, job, emolument, ptime, atime, other);
		boolean flag = false;
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		try {
			flag = CompanyJobFy.getCompanyJobFy().updateJobCompany(vo, jobid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			req.setAttribute("update_success", "招聘信息修改成功");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}else {
			req.setAttribute("update_error", "招聘信息修改失败，该工作编号不存在");
			req.getRequestDispatcher("update_companyjob.jsp").forward(req, res);
		}
	}
	/*
	 * 处理查询招聘信息
	 */
	public void findCompanyJob(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String cname = (String)session.getAttribute("cname");
		List<CjobVo> all = null;
		try {
			all = CompanyJobFy.getCompanyJobFy().findJobCompany(cname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(all!=null) {
			req.setAttribute("query_success", all);
			req.getRequestDispatcher("query_companyjob.jsp").forward(req, res);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}	
