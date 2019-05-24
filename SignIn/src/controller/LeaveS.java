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
 * @author  ����Ա�������Ϣ�Ŀ�����
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
				PrintWriter out = response.getWriter();//�������ã�
				String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
				switch (option) {
				case "getAllLeave":
					getAllLeave(request);
					break;
				case "getLeave"://ͨ��Ա����
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
				case "deleteLeaveInfo"://ͨ��Ա�����ɾ����ټ�¼
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
				int result = leaveInfo.deleteLeaveInfo(leave.getLeaID());//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				request.setAttribute("result", result);
				request.setAttribute("leave", leave);
				System.out.println(result);
				//msg������ҳ����ʾ�û���صĲ���
						String msg = "";
						if(result >=1){
							msg = "���³ɹ�";
						}else{
							msg = "����ʧ��";
						}
						request.setAttribute("msg", msg);
				url = "backstage/leaveInfo/list.jsp";//��ת�ĵ�ַ
				
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
				int result = leaveInfo.addLeaveInfo(leave);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				request.setAttribute("result", result);
				request.setAttribute("leave", leave);
				System.out.println(result);
				//msg������ҳ����ʾ�û���صĲ���
						String msg = "";
						if(result >=1){
							msg = "���³ɹ�";
						}else{
							msg = "����ʧ��";
						}
						request.setAttribute("msg", msg);
				url = "backstage/leaveInfo/list.jsp";//��ת�ĵ�ַ
				
			}
			public void getAllLeave(HttpServletRequest request) {
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
				pageInfo.setMaxResults("4");
				List<Leave> leaves;
				if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
					leaves = leaveInfo.getAllLeave();
				}else if(request.getParameter("leaveID")!=null && request.getParameter("leaveDate")==null) {
					leaves = (leaveInfo.getLeave(request.getParameter("leaveID"))) ;
				}else if(request.getParameter("leaveID")==null && request.getParameter("leaveDate")!=null) {
					leaves = leaveInfo.getLeaveByDate(request.getParameter("leaveDate"));
					//�ж��Ƿ�Ҫ�����
				}else{
					leaves = leaveInfo.getAllLeaveByPage(pageInfo);
				}
				//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("leaves", leaves);//leaves��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
			
				
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
				int result = leaveInfo.updateLeaveInfo(leave);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				request.setAttribute("result", result);
				request.setAttribute("leave", leave);
				System.out.println(result);
				//adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				//msg������ҳ����ʾ�û���صĲ���
				String msg = "";
				if(result >=1){
					msg = "���ӳɹ�";
				}else{
					msg = "����ʧ�ܣ�ԭ������Ǹ�ѧ���Ѵ���";
				}
				request.setAttribute("msg", msg);
				url = "backstage/leaveInfo/list.jsp";//��ת�ĵ�ַ

			
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doGet(request, response);
			}
			
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
