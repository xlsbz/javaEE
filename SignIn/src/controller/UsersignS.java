package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Applyinformation;
import entity.Meeting;
import entity.Usersign;
import page.PageInfo;
import dao.MeetInfo;
import dao.UsersignInfo;



/**
 * @author  操作会议信息的控制器
 * @Servlet implementation class MeetingC
 */
@WebServlet("/UsersignS")

public class UsersignS extends HttpServlet{
			private static final long serialVersionUID = 1L;
			UsersignInfo usersign;
			String url;
			
			public UsersignS() {
				usersign = new UsersignInfo();
			}

			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
		        response.setCharacterEncoding("utf-8");
		        response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();//这句的作用？
				String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
				switch (option) {
				case "getAllUsersign":
					getAllUsersign(request);
					break;
				case "getAllMeetingByPage":
					//getAllMeeting(request);
					break;
				case "getMeeting"://通过会议名称查询会议信息
					//getAllMeeting(request);
					break;
				case "getMeetingByType":
					//getAllMeeting(request);
					break;
				case "addSignUserInfo":
					addSignUserInfo(request);
					break;
				case "updateMeetingInfo":
					updateMeetingInfo(request);
					break;
				default:
					break;
				}
				request.getRequestDispatcher(url).forward(request, response);
			}			
			public void getAllUsersign(HttpServletRequest request) {
					String firstResult =  request.getParameter("firstResult");
					PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
					if(firstResult == null){
						firstResult = "0";
					}
					pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
					pageInfo.setMaxResults("4");
					List<Usersign> usersigns;
					if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
						usersigns = usersign.getAllUsersign();
					}else{
						usersigns = usersign.getAllUsersignByPage(pageInfo);
					}
					//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
					request.setAttribute("pageInfo", pageInfo);
					request.setAttribute("usersigns", usersigns);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
				
			}
			public void updateMeetingInfo(HttpServletRequest request) {
				
			}
			public void addSignUserInfo(HttpServletRequest request) {
					String userId = request.getParameter("userId");
					String userName = request.getParameter("userName");
					String userDeparent = request.getParameter("userDeparent");
					String userAdress = request.getParameter("userAdress");
					String userTime = request.getParameter("userTime");
					String userState = request.getParameter("userState");

					Usersign usersigns = new Usersign(userId,userName,userDeparent,userAdress,userTime,userState);
					int result = usersign.addSignUserInfo(usersigns);
					request.setAttribute("result", result);
					request.setAttribute("usersigns", usersigns);
					System.out.println(result);
					//adminInfo.addAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存	
					//msg用于在页面提示用户相关的操作
					String msg = "";
					if(result >=1){
						msg = "签到成功";
					}else{
						msg = "签到失败，原因可能是该活动不存在";
					}
					request.setAttribute("msg", msg);
					url = "home/index.jsp";//跳转的地址 
				}

			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doGet(request, response);
			}			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
