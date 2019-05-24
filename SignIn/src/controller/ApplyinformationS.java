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
import page.PageInfo;
import dao.ApplyinformationInfo;

/**
 * @author ����ǩ����Ϣ�Ŀ�����
 * @Servlet implementation class MeetingC
 */
@WebServlet("/ApplyinformationS")

public class ApplyinformationS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApplyinformationInfo applyinformation;
	String url;

	public ApplyinformationS() {
		applyinformation = new ApplyinformationInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();// �������ã�
		String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
		switch (option) {
		case "getAllApplyinformation":
			getAllApplyinformation(request);
			break;
		case "addApplyinformation":
			addApplyinformation(request);
			break;
		case "deletSignInInfo":// ͨ��ǩ�����ڲ�ѯǩ����Ϣ
			 deletSignInInfo(request);
			break;
		case "updateApplyinformation":// ����ǩ����Ϣ
			updateApplyinformation(request);
			break;
		case "getbyNumber":// ���ӻ���ǩ����Ϣ
			getbyNumber(request);
			break;
		case "getbyName":// ͨ������Ա��Ų�ѯ����ǩ����Ϣ
			getbyName(request);
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


	public void getAllApplyinformation(HttpServletRequest request) {
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
		pageInfo.setMaxResults("4");
		List<Applyinformation> applyinformations;
		if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
			applyinformations = applyinformation.getAllApplyinformation();
		}else{
			applyinformations = applyinformation.getAllApplyinformationByPage(pageInfo);
		}
		//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("applyinformations", applyinformations);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
	
}
	public void getbyNumber(HttpServletRequest request ){
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
		pageInfo.setMaxResults("8");
		List<Applyinformation> apply = applyinformation.getAllApplyinformationByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		String contNumber = request.getParameter("contNumber");
		List<Applyinformation> applyinformations = applyinformation.getbyNumber(contNumber);
		request.setAttribute("applyinformations", applyinformations);
		url = "home/apply/indexapply.jsp";//��ת�ĵ�ַ//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
	}
	
	public void getbyName(HttpServletRequest request ){
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
		pageInfo.setMaxResults("8");
		List<Applyinformation> apply = applyinformation.getAllApplyinformationByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		String contName = request.getParameter("contName");
		List<Applyinformation> applyinformations = applyinformation.getbyName(contName);
		request.setAttribute("applyinformations", applyinformations);
		url = "home/apply/myapply.jsp";//��ת�ĵ�ַ//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
	}
	
	public void addApplyinformation(HttpServletRequest request) {
		String contId = request.getParameter("contId");
		String contName = request.getParameter("contName");
		String contSex = request.getParameter("contSex");
		String contNumber = request.getParameter("contNumber");
		String contCard = request.getParameter("contCard");
		String contSchool = request.getParameter("contSchool");
		String contClass = request.getParameter("contClass");
		String contPhone = request.getParameter("contPhone");
		String contBeizhu = request.getParameter("contBeizhu");
		String applyId = request.getParameter("applyId");
		Applyinformation applyinformationInfo = new Applyinformation(contId,contName,contSex,contNumber,contCard,contSchool,contClass,contPhone,contBeizhu,applyId);
		int result = applyinformation.addApplyinformation(applyinformationInfo);
		request.setAttribute("result", result);
		request.setAttribute("applyinformationInfo", applyinformationInfo);
		System.out.println(result);
		//adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
		//msg������ҳ����ʾ�û���صĲ���
		String msg = "";
		if(result >=1){
			msg = "�����ɹ�";
		}else{
			msg = "����ʧ�ܣ�ԭ������Ǹñ���������";
		}
		request.setAttribute("msg", msg);
		url = "home/index.jsp";//��ת�ĵ�ַ 
	}
	public void updateApplyinformation(HttpServletRequest request) {
		String contId = request.getParameter("contId");
		String contName = request.getParameter("contName");
		String contSex = request.getParameter("contSex");
		String contNumber = request.getParameter("contNumber");
		String contCard = request.getParameter("contCard");
		String contSchool = request.getParameter("contSchool");
		String contClass = request.getParameter("contClass");
		String contPhone = request.getParameter("contPhone");
		String contBeizhu = request.getParameter("contBeizhu");
		String applyId = request.getParameter("applyId");
		Applyinformation applyinformationInfo = new Applyinformation(contId,contName,contSex,contNumber,contCard,contSchool,contClass,contPhone,contBeizhu,applyId);
			int result = applyinformation.updateApplyinformation(applyinformationInfo);
			request.setAttribute("result", result);
			request.setAttribute("applyinformationInfo", applyinformationInfo);
			System.out.println(result);
			//msg������ҳ����ʾ�û���صĲ���
					String msg = "";
					if(result >=1){
						msg = "���³ɹ�";
					}else{
						msg = "����ʧ��";
					}
					request.setAttribute("msg", msg);
					url = "home/index.jsp";//��ת�ĵ�ַ 

	}
	public void deletSignInInfo(HttpServletRequest request) {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
