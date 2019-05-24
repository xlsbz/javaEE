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
 * @author  ����������Ϣ�Ŀ�����
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
				PrintWriter out = response.getWriter();//�������ã�
				String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
				switch (option) {
				case "getAllMeeting":
					getAllMeeting(request);
					break;
				case "getAllMeetingByPage":
					getAllMeeting(request);
					break;
				case "getMeetByID"://ͨ���������Ʋ�ѯ������Ϣ
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
					PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
					if(firstResult == null){
						firstResult = "0";
					}
					pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
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
					request.setAttribute("meetings", meetings);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
				
			}
			
			public void getbyId(HttpServletRequest request ){
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
				pageInfo.setMaxResults("8");
				List<Meeting> meet = meetInfo.getAllMeetingByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				String admId = request.getParameter("admId");
				List<Meeting> meetings = meetInfo.getbyId(admId);
				request.setAttribute("meetings", meetings);
				url = "home/meet/indexmeet.jsp";//��ת�ĵ�ַ//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
			}
			
			public void getMeeting(HttpServletRequest request) {
				List<Meeting> meetings=null;
				request.setAttribute("meetings", meetings);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
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
				//msg������ҳ����ʾ�û���صĲ���
						String msg = "";
						if(result >=1){
							msg = "���³ɹ�";
						}else{
							msg = "����ʧ��";
						}
						request.setAttribute("msg", msg);
						url = "admin/meet/meetlist.jsp";//��ת�ĵ�ַ 
				
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
				//adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				//msg������ҳ����ʾ�û���صĲ���
				String msg = "";
				if(result >=1){
					msg = "���ӳɹ�";
				}else{
					msg = "����ʧ�ܣ�ԭ������Ǹû����Ѵ���";
				}
				request.setAttribute("msg", msg);
				url = "admin/meet/meetlist.jsp";//��ת�ĵ�ַ 
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
