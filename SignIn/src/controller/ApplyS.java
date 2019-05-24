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
 * @author  操作会议信息的控制器
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
				PrintWriter out = response.getWriter();//这句的作用？
				String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
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
				PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
				pageInfo.setMaxResults("8");
				List<Apply> applys = applyInfo.getApplyByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("applys", applys);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
			}
		
			
			public void getbyId(HttpServletRequest request ){
				String firstResult =  request.getParameter("firstResult");
				PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
				if(firstResult == null){
					firstResult = "0";
				}
				pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
				pageInfo.setMaxResults("8");
				List<Apply> apply = applyInfo.getApplyByPage(pageInfo);
				request.setAttribute("pageInfo", pageInfo);
				String applyId = request.getParameter("applyId");
				List<Apply> applys = applyInfo.getbyId(applyId);
				request.setAttribute("applys", applys);
				url = "home/apply/indexapply.jsp";//跳转的地址//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
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
				//msg用于在页面提示用户相关的操作
						String msg = "";
						if(result >=1){
							msg = "更新成功";
						}else{
							msg = "更新失败";
						}
						request.setAttribute("msg", msg);
						url = "admin/apply/listApply.jsp";//跳转的地址 
				
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
				//adminInfo.addAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存	
				//msg用于在页面提示用户相关的操作
				String msg = "";
				if(result >=1){
					msg = "增加成功";
				}else{
					msg = "增加失败，原因可能是该比赛已存在";
				}
				request.setAttribute("msg", msg);
				url = "admin/apply/listApply.jsp";//跳转的地址 
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
				int result = applyInfo.deleteApplyInfo(applyId);//将所有的数据封装到student对象之后，调用dao方法保存	
				request.setAttribute("result", result);
				//request.setAttribute("apply", apply);
				System.out.println(result);
				//msg用于在页面提示用户相关的操作
						String msg = "";
						if(result >=1){
							msg = "删除成功";
						}else{
							msg = "删除失败";
						}
						request.setAttribute("msg", msg);
				url = "admin/apply/listApply.jsp";//跳转的地址
				
			}
			public void getApplyByID(HttpServletRequest request) {
				Apply applyId = applyInfo.getApplyByID();
				request.setAttribute("applyId", applyId);
				
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
