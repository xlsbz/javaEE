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
import entity.Applyinformation;
import entity.Meeting;
import page.PageInfo;
import dao.MeetInfo;



/**
 * @author  操作会议信息的控制器
 * @Servlet implementation class MeetingC
 */
@WebServlet("/MeetS")

public class MeetS extends HttpServlet{
			private static final long serialVersionUID = 1L;
			MeetInfo meetInfo;
			String url;
			
			public MeetS() {
				meetInfo = new MeetInfo();
			}

			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
		        response.setCharacterEncoding("utf-8");
		        response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();//这句的作用？
				String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
				switch (option) {
				case "getAllMeeting":
					getAllMeeting(request);
					break;
				case "getAllMeetingByPage":
					getAllMeeting(request);
					break;
				case "getMeetByID"://通过会议名称查询会议信息
					getMeetByID(request);
					break;
				case "getbyId":
					getbyId(request);
					break;
				case "getMeetingByType":
					getAllMeeting(request);
					break;
				case "addMeetingInfo":
					addMeetingInfo(request);
					break;
				case "updateMeetingInfo":
					updateMeetingInfo(request);
					break;
				default:
					break;
				}
				request.getRequestDispatcher(url).forward(request, response);
			}			
			public void getAllMeeting(HttpServletRequest request) {
					String firstResult =  request.getParameter("firstResult");
					PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
					if(firstResult == null){
						firstResult = "0";
					}
					pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
					pageInfo.setMaxResults("4");
					List<Meeting> meetings;
					if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
						meetings = meetInfo.getAllMeeting();
					}else if(request.getParameter("mName")!=null && request.getParameter("mType") == null){
						meetings = meetInfo.getMeeting(request.getParameter("mName"));
					}else if(request.getParameter("mName")==null && request.getParameter("mType") != null){
						meetings = meetInfo.getMeeting(request.getParameter("mType"));
					}else{
						meetings = meetInfo.getAllMeetingByPage(pageInfo);
					}
					//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
					request.setAttribute("pageInfo", pageInfo);
					request.setAttribute("meetings", meetings);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
				
			}
			
			public void getbyId(HttpServletRequest request ){
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
				pageInfo.setMaxResults("8");
				List<Meeting> meet = meetInfo.getAllMeetingByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				String admId = request.getParameter("admId");
				List<Meeting> meetings = meetInfo.getbyId(admId);
				request.setAttribute("meetings", meetings);
				url = "home/meet/indexmeet.jsp";//跳转的地址//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
			}
			
			public void getMeeting(HttpServletRequest request) {
				List<Meeting> meetings=null;
				request.setAttribute("meetings", meetings);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
			}
				
			public void updateMeetingInfo(HttpServletRequest request) {
				String mType = request.getParameter("mType");
				String mTime = request.getParameter("mTime");
				String mAddress = request.getParameter("mAddress");
				String mState = request.getParameter("mState");
				String mName = request.getParameter("mName");
				String admId = request.getParameter("admId");
				
				Meeting meeting = new Meeting(mType,mTime,mAddress,mState,mName,admId);
				int result = meetInfo.updateMeetingInfo(meeting);
				request.setAttribute("result", result);
				request.setAttribute("meeting", meeting);
				System.out.println(result);
				//msg用于在页面提示用户相关的操作
						String msg = "";
						if(result >=1){
							msg = "更新成功";
						}else{
							msg = "更新失败";
						}
						request.setAttribute("msg", msg);
						url = "admin/meet/meetlist.jsp";//跳转的地址 
				
			}
			public void addMeetingInfo(HttpServletRequest request) {
				String mType = request.getParameter("mType");
				String mTime = request.getParameter("mTime");
				String mAddress = request.getParameter("mAddress");
				String mState = request.getParameter("mState");
				String mName = request.getParameter("mName");
				String admId = request.getParameter("admId");
				Meeting meeting = new Meeting(mType,mTime,mAddress,mState,mName,admId);
				int result = meetInfo.addMeetingInfo(meeting);
				request.setAttribute("result", result);
				request.setAttribute("meeting", meeting);
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
				url = "admin/meet/meetlist.jsp";//跳转的地址 
			}
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doGet(request, response);
			}			
			public void getMeetByID(HttpServletRequest request) {
				Meeting meeting = meetInfo.getMeetByID();
				request.setAttribute("meeting", meeting);
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
