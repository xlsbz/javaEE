package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Apply;
import entity.Meeting;
import entity.SignIn;
import page.PageInfo;
import dao.SignInInfo;

/**
 * @author 操作签到信息的控制器
 * @Servlet implementation class MeetingC
 */
@WebServlet("/SignInS")

public class SignInS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SignInInfo signInInfo;
	String url;

	public SignInS() {
		signInInfo = new SignInInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();// 这句的作用？
		String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
		switch (option) {
		case "getAllSignIn":
			getAllSignIn(request);
			break;
		case "addSignInInfo":// 通过员工工号查询员工签到信息
			addSignInInfo(request);
			break;
		case "deleteSignInInfo":// 通过签到日期查询签到信息
			 deleteSignInInfo(request);
			break;
		case "updateSignInInfo":// 增加签到信息
			updateSignInInfo(request);
			break;
		case "addMSI":// 增加会议签到信息
			// addMSI(request);
			break;
		case "getMSI":// 通过管理员编号查询会议签到信息
			// getAllSI(request);
			break;
		case "getMSIByDate":// 通过管理员编号查询会议签到信息
			// getAllSI(request);
			break;
		case "deleteAllWSI":// 通过管理员编号查询会议签到信息
			//deleteAllWSI(request);
			break;
		case "deleteAllMSI":// 通过管理员编号查询会议签到信息
			// deleteAllMSI(request);
			break;
		default:
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	public void getAllSignIn(HttpServletRequest request) {
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
		pageInfo.setMaxResults("4");
		List<SignIn> signins;
		if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
			signins = signInInfo.getAllSignIn();
		}else{
			signins = signInInfo.getAllSignInByPage(pageInfo);
		}
		//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("signins", signins);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
	
}
	public void getSignInByID(HttpServletRequest request) {
		SignIn signin = signInInfo.getSignInByID();
		request.setAttribute("signin", signin);
	}
	public void addSignInInfo(HttpServletRequest request) {
		String signId = request.getParameter("signId");
		String signNumber = request.getParameter("signNumber");
		String signAdress = request.getParameter("signAdress");
		String signTime = request.getParameter("signTime");
		String signBeizhu = request.getParameter("signBeizhu");
		String admId = request.getParameter("admId");
		SignIn sigin = new SignIn(signId,signNumber,signAdress,signTime,signBeizhu,admId);
		int result = signInInfo.addSignInfo(sigin);
		request.setAttribute("result", result);
		request.setAttribute("sigin", sigin);
		System.out.println(result);
		//adminInfo.addAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存	
		//msg用于在页面提示用户相关的操作
		String msg = "";
		if(result >=1){
			msg = "增加成功";
		}else{
			msg = "增加失败，原因可能是该会议已存在";
		}
		request.setAttribute("msg", msg);
		url = "admin/sign/signlist.jsp";//跳转的地址 
	}
	public void updateSignInInfo(HttpServletRequest request) {
		String signId = request.getParameter("signId");
		String signNumber = request.getParameter("signNumber");
		String signAdress = request.getParameter("signAdress");
		String signTime = request.getParameter("signTime");
		String signBeizhu = request.getParameter("signBeizhu");
		String admId = request.getParameter("admId");
		SignIn sigin = new SignIn(signId,signNumber,signAdress,signTime,signBeizhu,admId);
		int result = signInInfo.updateSignInInfo(sigin);
		request.setAttribute("result", result);
		request.setAttribute("sigin", sigin);
		System.out.println(result);
		//msg用于在页面提示用户相关的操作
				String msg = "";
				if(result >=1){
					msg = "更新成功";
				}else{
					msg = "更新失败";
				}
				request.setAttribute("msg", msg);
				url = "admin/sign/signlist.jsp";//跳转的地址 
		
	}
	public void deleteSignInInfo(HttpServletRequest request) {
		String signId = request.getParameter("signId"); ;        
		int result = signInInfo.deleteSignInInfo(signId);//将所有的数据封装到student对象之后，调用dao方法保存	
		request.setAttribute("result", result);
		//request.setAttribute("admin", admin);
		System.out.println(result);
		//msg用于在页面提示用户相关的操作
				String msg = "";
				if(result >=1){
					msg = "删除成功";
				}else{
					msg = "删除失败";
				}
				request.setAttribute("msg", msg);
		url = "admin/sign/signlist.jsp";//跳转的地址
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
