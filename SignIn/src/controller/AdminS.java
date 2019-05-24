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
 * @author  ��������Ա��Ϣ�Ŀ�����
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
			String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
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
			int result = adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������
			request.setAttribute("result", result);
			request.setAttribute("admin", admin);
			//msg������ҳ����ʾ�û���صĲ���
			String msg = "";
			if(result >=1){
				msg = "���ӳɹ�";
			}else{
				msg = "����ʧ�ܣ�ԭ������Ǹù���Ա�Ѵ���";
			}
			request.setAttribute("msg", msg);

			url = "admin/admin/list.jsp";//��ת�ĵ�ַ
		}

		public void updateAdminInfo(HttpServletRequest request) {
			String admId = request.getParameter("admId"); ;        
			int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
			String admPsd = request.getParameter("admPsd");              
		    String admState = request.getParameter("admState");           
		    String admPower = request.getParameter("admPower");            
		    String admPhone = request.getParameter("admPhone");            
			Admin admin = new Admin( admId,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
			int result = adminInfo.updateAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
			request.setAttribute("result", result);
			request.setAttribute("admin", admin);
			System.out.println(result);
			//msg������ҳ����ʾ�û���صĲ���
					String msg = "";
					if(result >=1){
						msg = "���³ɹ�";
					}else{
						msg = "����ʧ��";
					}
					request.setAttribute("msg", msg);
			url = "admin/admin/list.jsp";//��ת�ĵ�ַ
			
		}
		

		public void deletAdminInfo(HttpServletRequest request) {
			String admID = request.getParameter("admID"); ;        
			//int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
			//String admPsd = request.getParameter("admPsd");              
		    //String admState = request.getParameter("admState");           
		    //String admPower = request.getParameter("admPower");            
		    //String admPhone = request.getParameter("admPhone");            
			//Admin admin = new Admin( admID,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
			int result = adminInfo.deleteAdminInfo(admID);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
			request.setAttribute("result", result);
			//request.setAttribute("admin", admin);
			System.out.println(result);
			//msg������ҳ����ʾ�û���صĲ���
					String msg = "";
					if(result >=1){
						msg = "ɾ���ɹ�";
					}else{
						msg = "ɾ��ʧ��";
					}
					request.setAttribute("msg", msg);
			url = "admin/admin/list.jsp";//��ת�ĵ�ַ
			
		}
		public void delAdminInfo(HttpServletRequest request) {
			//String admNumber = request.getParameter("admNumber"); ;        
			int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
			//String admPsd = request.getParameter("admPsd");              
		    //String admState = request.getParameter("admState");           
		    //String admPower = request.getParameter("admPower");            
		    //String admPhone = request.getParameter("admPhone");            
			//Admin admin = new Admin( admID,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
			int result = adminInfo.deleteAdminInfo(admNumber);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
			request.setAttribute("result", result);
			//request.setAttribute("admin", admin);
			System.out.println(result);
			//msg������ҳ����ʾ�û���صĲ���
					String msg = "";
					if(result >=1){
						msg = "ɾ���ɹ�";
					}else{
						msg = "ɾ��ʧ��";
					}
					request.setAttribute("msg", msg);
			url = "admin/admin/list.jsp";//��ת�ĵ�ַ
			
		}

		public void getAllAdmin(HttpServletRequest request ){
			String firstResult =  request.getParameter("firstResult");
			PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
			if(firstResult == null){
				firstResult = "0";
			}
			pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
			pageInfo.setMaxResults("8");
			List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("admins", admins);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
		}
		//��ѯһ�����������Ľ��
//		public void getAdminByAdmin(HttpServletRequest request){
//			String adminId = request.getParameter("adminId");
//			Admin admin = adminInfo.getAdminByAdmin(adminId);
//			request.setAttribute("admin", admin);
//			url = "admin/admin/checklist.jsp";//��ת�ĵ�ַ
//		}
		//��ѯ������������Ľ����
		public void getbyphone(HttpServletRequest request ){
			String firstResult =  request.getParameter("firstResult");
			PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
			if(firstResult == null){
				firstResult = "0";
			}
			pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
			pageInfo.setMaxResults("8");
			List<Admin> admin = adminInfo.getAllAdminByPage(pageInfo);
			request.setAttribute("pageInfo", pageInfo);
			String admPhone = request.getParameter("admPhone");
			List<Admin> admins = adminInfo.getbyphone(admPhone);
			request.setAttribute("admins", admins);
			url = "admin/admin/checklist.jsp";//��ת�ĵ�ַ//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
