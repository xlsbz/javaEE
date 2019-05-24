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
 * @author  ����������Ϣ�Ŀ�����
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
				PrintWriter out = response.getWriter();//�������ã�
				String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
				switch (option) {
				case "getAllUsersign":
					getAllUsersign(request);
					break;
				case "getAllMeetingByPage":
					//getAllMeeting(request);
					break;
				case "getMeeting"://ͨ���������Ʋ�ѯ������Ϣ
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
					PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
					if(firstResult == null){
						firstResult = "0";
					}
					pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
					pageInfo.setMaxResults("4");
					List<Usersign> usersigns;
					if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
						usersigns = usersign.getAllUsersign();
					}else{
						usersigns = usersign.getAllUsersignByPage(pageInfo);
					}
					//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
					request.setAttribute("pageInfo", pageInfo);
					request.setAttribute("usersigns", usersigns);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
				
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
					//adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
					//msg������ҳ����ʾ�û���صĲ���
					String msg = "";
					if(result >=1){
						msg = "ǩ���ɹ�";
					}else{
						msg = "ǩ��ʧ�ܣ�ԭ������Ǹû������";
					}
					request.setAttribute("msg", msg);
					url = "home/index.jsp";//��ת�ĵ�ַ 
				}

			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doGet(request, response);
			}			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
