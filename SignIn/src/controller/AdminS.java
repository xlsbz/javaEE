package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import page.PageInfo;
import dao.AdminInfo;


/**
 * @author  操作管理员信息的控制器
 * @Servlet implementation class AdminC
 */
@WebServlet("/AdminS")

public class AdminS extends HttpServlet{
		
		private static final long serialVersionUID = 1L;
		AdminInfo adminInfo;
	    String url;
		
		public AdminS() {
			adminInfo = new AdminInfo();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
			switch (option) {
			case "getAllAdmin":
				getAllAdmin(request);
				break;
			case "add":
				addAdminInfo(request);
				break;
			case "searchTeacherByName":

				break;
			case "getbyphone":
				getbyphone(request);
				break;
			case "getTeacherBySno":

				break;
			case "updateInfo":
				updateAdminInfo(request);
				break;
			case "getAdminByAdmin":
				//getAdminByAdmin(request);
				break;
			case "deleteAdminInfo":
				deletAdminInfo(request);
				break;
			case "delAdminInfo":
				delAdminInfo(request);
				break;
			default:
				break;
			}
			 request.getRequestDispatcher(url).forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doGet(request, response);
		}
		
		public void addAdminInfo(HttpServletRequest request) {
			String admId = request.getParameter("admId");
			int admNumber = Integer.parseInt(request.getParameter("admNumber"));
			String admPsd = request.getParameter("admPsd");
			String admState = request.getParameter("admState");
			String admPower = request.getParameter("admPower");
			String admPhone = request.getParameter("admPhone");
			Admin admin = new Admin(admId,  admNumber,  admPsd,  admState,  admPower,  admPhone);
			//System.out.println(admin.getAdmId());
			int result = adminInfo.addAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存
			request.setAttribute("result", result);
			request.setAttribute("admin", admin);
			//msg用于在页面提示用户相关的操作
			String msg = "";
			if(result >=1){
				msg = "增加成功";
			}else{
				msg = "增加失败，原因可能是该管理员已存在";
			}
			request.setAttribute("msg", msg);

			url = "admin/admin/list.jsp";//跳转的地址
		}

		public void updateAdminInfo(HttpServletRequest request) {
			String admId = request.getParameter("admId"); ;        
			int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
			String admPsd = request.getParameter("admPsd");              
		    String admState = request.getParameter("admState");           
		    String admPower = request.getParameter("admPower");            
		    String admPhone = request.getParameter("admPhone");            
			Admin admin = new Admin( admId,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
			int result = adminInfo.updateAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存	
			request.setAttribute("result", result);
			request.setAttribute("admin", admin);
			System.out.println(result);
			//msg用于在页面提示用户相关的操作
					String msg = "";
					if(result >=1){
						msg = "更新成功";
					}else{
						msg = "更新失败";
					}
					request.setAttribute("msg", msg);
			url = "admin/admin/list.jsp";//跳转的地址
			
		}
		

		public void deletAdminInfo(HttpServletRequest request) {
			String admID = request.getParameter("admID"); ;        
			//int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
			//String admPsd = request.getParameter("admPsd");              
		    //String admState = request.getParameter("admState");           
		    //String admPower = request.getParameter("admPower");            
		    //String admPhone = request.getParameter("admPhone");            
			//Admin admin = new Admin( admID,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
			int result = adminInfo.deleteAdminInfo(admID);//将所有的数据封装到student对象之后，调用dao方法保存	
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
			url = "admin/admin/list.jsp";//跳转的地址
			
		}
		public void delAdminInfo(HttpServletRequest request) {
			//String admNumber = request.getParameter("admNumber"); ;        
			int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
			//String admPsd = request.getParameter("admPsd");              
		    //String admState = request.getParameter("admState");           
		    //String admPower = request.getParameter("admPower");            
		    //String admPhone = request.getParameter("admPhone");            
			//Admin admin = new Admin( admID,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
			int result = adminInfo.deleteAdminInfo(admNumber);//将所有的数据封装到student对象之后，调用dao方法保存	
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
			url = "admin/admin/list.jsp";//跳转的地址
			
		}

		public void getAllAdmin(HttpServletRequest request ){
			String firstResult =  request.getParameter("firstResult");
			PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
			if(firstResult == null){
				firstResult = "0";
			}
			pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
			pageInfo.setMaxResults("8");
			List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("admins", admins);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
		}
		//查询一个满足条件的结果
//		public void getAdminByAdmin(HttpServletRequest request){
//			String adminId = request.getParameter("adminId");
//			Admin admin = adminInfo.getAdminByAdmin(adminId);
//			request.setAttribute("admin", admin);
//			url = "admin/admin/checklist.jsp";//跳转的地址
//		}
		//查询多个满足条件的结果集
		public void getbyphone(HttpServletRequest request ){
			String firstResult =  request.getParameter("firstResult");
			PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
			if(firstResult == null){
				firstResult = "0";
			}
			pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
			pageInfo.setMaxResults("8");
			List<Admin> admin = adminInfo.getAllAdminByPage(pageInfo);
			request.setAttribute("pageInfo", pageInfo);
			String admPhone = request.getParameter("admPhone");
			List<Admin> admins = adminInfo.getbyphone(admPhone);
			request.setAttribute("admins", admins);
			url = "admin/admin/checklist.jsp";//跳转的地址//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
