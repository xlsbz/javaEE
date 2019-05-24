package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Leave;
import page.PageInfo;
import dao.LeaveInfo;


/**
 * @author  操作员工请假信息的控制器
 * @Servlet implementation class LeaveC
 */
@WebServlet("/LeaveC")

public final class LeaveS extends HttpServlet {

			private static final long serialVersionUID = 1L;
			LeaveInfo leaveInfo;
			String url;
			
			public LeaveS() {
				leaveInfo = new LeaveInfo();
			}

			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
		        response.setCharacterEncoding("utf-8");
		        response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();//这句的作用？
				String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
				switch (option) {
				case "getAllLeave":
					getAllLeave(request);
					break;
				case "getLeave"://通过员工号
					getAllLeave(request);
					break;
				case "getLeaveByDate":
					getAllLeave(request);
					break;
				case "getAllLeaveByPage":
					getAllLeave(request);
					break;
				case "addLeaveInfo":
					addLeaveInfo(request);
					break;
				case "updateLeaveInfo":
					updateLeaveInfo(request);
					break;
				case "deleteLeaveInfo"://通过员工编号删除请假记录
					deleteLeaveInfo(request);
					break;

				default:
					break;
				}
				request.getRequestDispatcher(url).forward(request, response);
			}

			public void deleteLeaveInfo(HttpServletRequest request) {
				String leaID = request.getParameter("leaID"); 
				String leaDate = request.getParameter("leaDate");             
			    String leaTime = request.getParameter("leaTime");     
			    String leaState = request.getParameter("leaState");         
			    int leaOrderNum = Integer.parseInt(request.getParameter("leaOrderNum"));
			    String admID = request.getParameter("admID");
			    String wiID = request.getParameter("wiID");
				
				Leave leave = new Leave( leaID,  leaDate,  leaTime,  leaState,  leaOrderNum,  admID, wiID) ;
				int result = leaveInfo.deleteLeaveInfo(leave.getLeaID());//将所有的数据封装到student对象之后，调用dao方法保存	
				request.setAttribute("result", result);
				request.setAttribute("leave", leave);
				System.out.println(result);
				//msg用于在页面提示用户相关的操作
						String msg = "";
						if(result >=1){
							msg = "更新成功";
						}else{
							msg = "更新失败";
						}
						request.setAttribute("msg", msg);
				url = "backstage/leaveInfo/list.jsp";//跳转的地址
				
			}

			public void updateLeaveInfo(HttpServletRequest request) {
				String leaID = request.getParameter("leaID"); 
				String leaDate = request.getParameter("leaDate");             
			    String leaTime = request.getParameter("leaTime");     
			    String leaState = request.getParameter("leaState");         
			    int leaOrderNum = Integer.parseInt(request.getParameter("leaOrderNum"));
			    String admID = request.getParameter("admID");
			    String wiID = request.getParameter("wiID");
				
				Leave leave = new Leave( leaID,  leaDate,  leaTime,  leaState,  leaOrderNum,  admID, wiID) ;
				int result = leaveInfo.addLeaveInfo(leave);//将所有的数据封装到student对象之后，调用dao方法保存	
				request.setAttribute("result", result);
				request.setAttribute("leave", leave);
				System.out.println(result);
				//msg用于在页面提示用户相关的操作
						String msg = "";
						if(result >=1){
							msg = "更新成功";
						}else{
							msg = "更新失败";
						}
						request.setAttribute("msg", msg);
				url = "backstage/leaveInfo/list.jsp";//跳转的地址
				
			}
			public void getAllLeave(HttpServletRequest request) {
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
				pageInfo.setMaxResults("4");
				List<Leave> leaves;
				if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
					leaves = leaveInfo.getAllLeave();
				}else if(request.getParameter("leaveID")!=null && request.getParameter("leaveDate")==null) {
					leaves = (leaveInfo.getLeave(request.getParameter("leaveID"))) ;
				}else if(request.getParameter("leaveID")==null && request.getParameter("leaveDate")!=null) {
					leaves = leaveInfo.getLeaveByDate(request.getParameter("leaveDate"));
					//判断是否按要求查找
				}else{
					leaves = leaveInfo.getAllLeaveByPage(pageInfo);
				}
				//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("leaves", leaves);//leaves是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
			
				
			}

			public void addLeaveInfo(HttpServletRequest request) {
				String leaID = request.getParameter("leaID"); 
				String leaDate = request.getParameter("leaDate");             
			    String leaTime = request.getParameter("leaTime");     
			    String leaState = request.getParameter("leaState");         
			    int leaOrderNum = Integer.parseInt(request.getParameter("leaOrderNum"));
			    String admID = request.getParameter("admID");
			    String wiID = request.getParameter("wiID");
				
				Leave leave = new Leave( leaID,  leaDate,  leaTime,  leaState,  leaOrderNum,  admID, wiID) ;
				int result = leaveInfo.updateLeaveInfo(leave);//将所有的数据封装到student对象之后，调用dao方法保存	
				request.setAttribute("result", result);
				request.setAttribute("leave", leave);
				System.out.println(result);
				//adminInfo.addAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存	
				//msg用于在页面提示用户相关的操作
				String msg = "";
				if(result >=1){
					msg = "增加成功";
				}else{
					msg = "增加失败，原因可能是该学号已存在";
				}
				request.setAttribute("msg", msg);
				url = "backstage/leaveInfo/list.jsp";//跳转的地址

			
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doGet(request, response);
			}
			
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
