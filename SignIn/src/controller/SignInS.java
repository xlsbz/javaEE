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
 * @author ����ǩ����Ϣ�Ŀ�����
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
		PrintWriter out = response.getWriter();// �������ã�
		String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
		switch (option) {
		case "getAllSignIn":
			getAllSignIn(request);
			break;
		case "addSignInInfo":// ͨ��Ա�����Ų�ѯԱ��ǩ����Ϣ
			addSignInInfo(request);
			break;
		case "deleteSignInInfo":// ͨ��ǩ�����ڲ�ѯǩ����Ϣ
			 deleteSignInInfo(request);
			break;
		case "updateSignInInfo":// ����ǩ����Ϣ
			updateSignInInfo(request);
			break;
		case "addMSI":// ���ӻ���ǩ����Ϣ
			// addMSI(request);
			break;
		case "getMSI":// ͨ������Ա��Ų�ѯ����ǩ����Ϣ
			// getAllSI(request);
			break;
		case "getMSIByDate":// ͨ������Ա��Ų�ѯ����ǩ����Ϣ
			// getAllSI(request);
			break;
		case "deleteAllWSI":// ͨ������Ա��Ų�ѯ����ǩ����Ϣ
			//deleteAllWSI(request);
			break;
		case "deleteAllMSI":// ͨ������Ա��Ų�ѯ����ǩ����Ϣ
			// deleteAllMSI(request);
			break;
		default:
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	public void getAllSignIn(HttpServletRequest request) {
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
		pageInfo.setMaxResults("4");
		List<SignIn> signins;
		if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
			signins = signInInfo.getAllSignIn();
		}else{
			signins = signInInfo.getAllSignInByPage(pageInfo);
		}
		//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("signins", signins);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
	
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
		//adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
		//msg������ҳ����ʾ�û���صĲ���
		String msg = "";
		if(result >=1){
			msg = "���ӳɹ�";
		}else{
			msg = "����ʧ�ܣ�ԭ������Ǹû����Ѵ���";
		}
		request.setAttribute("msg", msg);
		url = "admin/sign/signlist.jsp";//��ת�ĵ�ַ 
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
		//msg������ҳ����ʾ�û���صĲ���
				String msg = "";
				if(result >=1){
					msg = "���³ɹ�";
				}else{
					msg = "����ʧ��";
				}
				request.setAttribute("msg", msg);
				url = "admin/sign/signlist.jsp";//��ת�ĵ�ַ 
		
	}
	public void deleteSignInInfo(HttpServletRequest request) {
		String signId = request.getParameter("signId"); ;        
		int result = signInInfo.deleteSignInInfo(signId);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
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
		url = "admin/sign/signlist.jsp";//��ת�ĵ�ַ
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
