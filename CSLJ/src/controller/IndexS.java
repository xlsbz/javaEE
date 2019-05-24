package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.AdminFy;
import vo.CjobVo;
import vo.SjobVo;

/**
 * Ö÷Ò³¼ÓÔØ
 * @author Mr DU
 *
 */
public class IndexS extends HttpServlet{
 	@Override
 	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		doPost(req, res);
 	}
 	@Override
 	public void init() throws ServletException {
 	}
 	@Override
 	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		List<SjobVo> sjobVo = null;
 		List<CjobVo> cjobVo = null;
 		try {
 			sjobVo = AdminFy.getAdminInstance().findAllSjob();
 			cjobVo = AdminFy.getAdminInstance().findAllCjob();
		} catch (Exception e) {
			e.printStackTrace();
		}
 		HttpSession session = req.getSession();
 		session.setAttribute("all_sjob", sjobVo);
 		session.setAttribute("all_cjob", cjobVo);
 	}
}
