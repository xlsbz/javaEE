package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.StudentJobFy;
import vo.CjobVo;
import vo.SjobVo;

/**
 * ������ְ��Ϣ�Ŀ�����
 * 
 * @author Mr DU ��������û�в���ע�ⷽʽ��������Ҫ����xml
 */
public class StudentJobS extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		switch (option) {
		case "add_sjob":
			try {
				addSjob(req, res);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "getAll_jobs":
			getAllJob(req, res);
			break;
		case "delete_jobs":
			deleteJob(req, res);
			break;
		case "to_update":
			toupdate(req, res);
		case "update_job":
			try {
				updateJob(req, res);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	/**
	 * ��ְ��Ϣ����
	 * 
	 * @throws ParseException
	 */
	public void addSjob(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String sname = req.getParameter("sname");
		String specialty = req.getParameter("specialty");
		String job = req.getParameter("job");
		String emolument = req.getParameter("emolument");
		Date ptime = dateFormat.parse(req.getParameter("ptime"));
		Date atime = dateFormat.parse(req.getParameter("atime"));
		String other = req.getParameter("other");
		SjobVo sjobVo = new SjobVo(sname, specialty, job, emolument, ptime, atime, other);
		try {
			if (StudentJobFy.getStudentJob().addStudentJob(sjobVo)) {
				req.setAttribute("job_success", "��Ϣ�����ɹ���");
				req.getRequestDispatcher("index.jsp").forward(req, res);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �鿴��ְ��Ϣ
	 * 
	 * @throws ParseException
	 */
	public void getAllJob(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String sname = session.getAttribute("sname").toString();
		try {
			List<SjobVo> all = StudentJobFy.getStudentJob().getAllSjob(sname);
			req.setAttribute("getAllJobs", all);
			req.getRequestDispatcher("query_studentjobs.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ɾ����ְ��Ϣ
	 * 
	 * @throws IOException
	 * @throws ServletException
	 * @throws ParseException
	 */
	public void deleteJob(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int jobid = 0;
		boolean flag = false;
		try {
			jobid = Integer.parseInt(req.getParameter("jobid"));
			flag = StudentJobFy.getStudentJob().delStudentJob(jobid);
		} catch (Exception e) {
			req.setAttribute("deljob_error", "ɾ��ʧ�ܣ���û��ѡ������");
			req.getRequestDispatcher("success.jsp").forward(req, res);
			e.printStackTrace();
		}
		if (flag) {
			req.setAttribute("deljob_success", "ɾ��" + jobid + "��ְ��Ϣ�ɹ�");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}
	}
	/*
	 * ͨ���޸���ְ��Ϣ
	 */
	public void toupdate(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		SjobVo vo = null;
		try {
			vo = StudentJobFy.getStudentJob().findJobId(jobid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		req.setAttribute("update", vo);
		req.getRequestDispatcher("update_studentjob.jsp").forward(req, res);
		
	}
	/*
	 * �޸���ְ��Ϣ
	 */
	public void updateJob(HttpServletRequest req, HttpServletResponse res)
			throws ParseException, ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String sname = req.getParameter("sname");
		String specialty = req.getParameter("specialty");
		String job = req.getParameter("job");
		String emolument = req.getParameter("emolument");
		Date ptime = dateFormat.parse(req.getParameter("ptime"));
		Date atime = dateFormat.parse(req.getParameter("atime"));
		String other = req.getParameter("other");
		SjobVo sjobVo = new SjobVo(sname, specialty, job, emolument, ptime, atime, other);
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		boolean flag = false;
		try {
			flag = StudentJobFy.getStudentJob().updateStudentJob(sjobVo, jobid);
		} catch (Exception e) {
			req.setAttribute("msg_del", "ɾ��ʧ�ܣ���û��ѡ������");
			req.getRequestDispatcher("success.jsp").forward(req, res);
			e.printStackTrace();
		}
		if (flag) {
			req.setAttribute("updatejob_success", "�޸�" + jobid + "��ְ��Ϣ�ɹ�");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		} else {
			req.setAttribute("updatejob_error", "�޸�" + jobid + "��ְ��Ϣʧ�ܣ�������ı��");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}
	}

	/*
	 * doget��ת
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
