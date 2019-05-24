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
import entity.Apply;
import page.PageInfo;
import dao.ApplyInfo;




/**
 * @author  ����������Ϣ�Ŀ�����
 * @Servlet implementation class MeetingC
 */
@WebServlet("/ApplyS")

public class ApplyS extends HttpServlet{
			private static final long serialVersionUID = 1L;
			ApplyInfo applyInfo;
			String url;
			
			public ApplyS() {
				applyInfo = new ApplyInfo();
			}
	

			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
		        response.setCharacterEncoding("utf-8");
		        response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();//�������ã�
				String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
				switch (option) {
				case "getAllApply":
					getAllApply(request);
					break;
				case "getApplyByID":
					getApplyByID(request);
					break;
				case "getbyId":
					getbyId(request);
					break;
				case "addApplyInfo":
					addApplyInfo(request);
					break;
				case "updateApplyInfo":
					updateApplyInfo(request);
					break;
				case "deleteApplyInfo":
					deleteApplyInfo(request);
					break;
				default:
					break;
				}
				request.getRequestDispatcher(url).forward(request, response);
			}			
			public void getAllApply(HttpServletRequest request ){
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
				pageInfo.setMaxResults("8");
				List<Apply> applys = applyInfo.getApplyByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("applys", applys);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
			}
		
			
			public void getbyId(HttpServletRequest request ){
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
				pageInfo.setMaxResults("8");
				List<Apply> apply = applyInfo.getApplyByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				String applyId = request.getParameter("applyId");
				List<Apply> applys = applyInfo.getbyId(applyId);
				request.setAttribute("applys", applys);
				url = "home/apply/indexapply.jsp";//��ת�ĵ�ַ//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
			}
			public void updateApplyInfo(HttpServletRequest request) {
				
				String applyId = request.getParameter("applyId");
				String applyName = request.getParameter("applyName");
				String applyTimestart = request.getParameter("applyTimestart");
				String applyTimeend = request.getParameter("applyTimeend");
				String applyType = request.getParameter("applyType");
				String applyState = request.getParameter("applyState");
				String applyInformation = request.getParameter("applyInformation");
				String applyAdress = request.getParameter("applyAdress");
				String applyWin = request.getParameter("applyWin");
				String applyPhone = request.getParameter("applyPhone");
				String applyBeizhu = request.getParameter("applyBeizhu");
				String admId = request.getParameter("admId");
				
				Apply apply = new Apply(applyId,applyName,applyTimestart,applyTimeend,applyType,applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
				int result = applyInfo.updateApplyInfo(apply);
				request.setAttribute("result", result);
				request.setAttribute("apply", apply);
				System.out.println(result);
				//msg������ҳ����ʾ�û���صĲ���
						String msg = "";
						if(result >=1){
							msg = "���³ɹ�";
						}else{
							msg = "����ʧ��";
						}
						request.setAttribute("msg", msg);
						url = "admin/apply/listApply.jsp";//��ת�ĵ�ַ 
				
			}
			public void addApplyInfo(HttpServletRequest request) {
				
				String applyId = request.getParameter("applyId");
				String applyName = request.getParameter("applyName");
				String applyTimestart = request.getParameter("applyTimestart");
				String applyTimeend = request.getParameter("applyTimeend");
				String applyType = request.getParameter("applyType");
				String applyState = request.getParameter("applyState");
				String applyInformation = request.getParameter("applyInformation");
				String applyAdress = request.getParameter("applyAdress");
				String applyWin = request.getParameter("applyWin");
				String applyPhone = request.getParameter("applyPhone");
				String applyBeizhu = request.getParameter("applyBeizhu");
				String admId = request.getParameter("admId");
				Apply apply = new Apply(applyId,applyName,applyTimestart,applyTimeend,applyType,applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
				int result = applyInfo.addApplyInfo(apply);
				request.setAttribute("result", result);
				request.setAttribute("apply", apply);
				System.out.println(result);
				//adminInfo.addAdminInfo(admin);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				//msg������ҳ����ʾ�û���صĲ���
				String msg = "";
				if(result >=1){
					msg = "���ӳɹ�";
				}else{
					msg = "����ʧ�ܣ�ԭ������Ǹñ����Ѵ���";
				}
				request.setAttribute("msg", msg);
				url = "admin/apply/listApply.jsp";//��ת�ĵ�ַ 
			}
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doGet(request, response);
			}			
			public void deleteApplyInfo(HttpServletRequest request) {
				String applyId = request.getParameter("applyId"); ;        
				//int admNumber = Integer.parseInt(request.getParameter("admNumber"));   
				//String admPsd = request.getParameter("admPsd");              
			    //String admState = request.getParameter("admState");           
			    //String admPower = request.getParameter("admPower");            
			    //String admPhone = request.getParameter("admPhone");            
				//Admin admin = new Admin( admID,  admNumber,  admPsd,  admState,  admPower, admPhone) ;
				int result = applyInfo.deleteApplyInfo(applyId);//�����е����ݷ�װ��student����֮�󣬵���dao��������	
				request.setAttribute("result", result);
				//request.setAttribute("apply", apply);
				System.out.println(result);
				//msg������ҳ����ʾ�û���صĲ���
						String msg = "";
						if(result >=1){
							msg = "ɾ���ɹ�";
						}else{
							msg = "ɾ��ʧ��";
						}
						request.setAttribute("msg", msg);
				url = "admin/apply/listApply.jsp";//��ת�ĵ�ַ
				
			}
			public void getApplyByID(HttpServletRequest request) {
				Apply applyId = applyInfo.getApplyByID();
				request.setAttribute("applyId", applyId);
				
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
