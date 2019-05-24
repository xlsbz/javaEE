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
 * @author 操作签到信息的控制器
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
		PrintWriter out = response.getWriter();// 这句的作用？
		String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
		switch (option) {
		case "getAllApplyinformation":
			getAllApplyinformation(request);
			break;
		case "addApplyinformation":
			addApplyinformation(request);
			break;
		case "deletSignInInfo":// 通过签到日期查询签到信息
			 deletSignInInfo(request);
			break;
		case "updateApplyinformation":// 增加签到信息
			updateApplyinformation(request);
			break;
		case "getbyNumber":// 增加会议签到信息
			getbyNumber(request);
			break;
		case "getbyName":// 通过管理员编号查询会议签到信息
			getbyName(request);
			break;
		case "getMSIByDate":// 通过管理员编号查询会议签到信息
			// getAllSI(request);
			break;
		case "deleteAllWSI":// 通过管理员编号查询会议签到信息
			//deleteAllWSI(request);
			break;
		case "deleteAllMSI":// 通过管理员编号查询会议签到信息
			// deleteAllMSI(request);
			break;
		default:
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}


	public void getAllApplyinformation(HttpServletRequest request) {
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
		pageInfo.setMaxResults("4");
		List<Applyinformation> applyinformations;
		if(request.getParameter("suboption")!=null&&request.getParameter("suboption").equals("nopage")){
			applyinformations = applyinformation.getAllApplyinformation();
		}else{
			applyinformations = applyinformation.getAllApplyinformationByPage(pageInfo);
		}
		//List<Admin> admins = adminInfo.getAllAdminByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("applyinformations", applyinformations);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
	
}
	public void getbyNumber(HttpServletRequest request ){
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
		pageInfo.setMaxResults("8");
		List<Applyinformation> apply = applyinformation.getAllApplyinformationByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		String contNumber = request.getParameter("contNumber");
		List<Applyinformation> applyinformations = applyinformation.getbyNumber(contNumber);
		request.setAttribute("applyinformations", applyinformations);
		url = "home/apply/indexapply.jsp";//跳转的地址//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
	}
	
	public void getbyName(HttpServletRequest request ){
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
		pageInfo.setMaxResults("8");
		List<Applyinformation> apply = applyinformation.getAllApplyinformationByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		String contName = request.getParameter("contName");
		List<Applyinformation> applyinformations = applyinformation.getbyName(contName);
		request.setAttribute("applyinformations", applyinformations);
		url = "home/apply/myapply.jsp";//跳转的地址//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
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
		//adminInfo.addAdminInfo(admin);//将所有的数据封装到student对象之后，调用dao方法保存	
		//msg用于在页面提示用户相关的操作
		String msg = "";
		if(result >=1){
			msg = "报名成功";
		}else{
			msg = "报名失败，原因可能是该比赛不存在";
		}
		request.setAttribute("msg", msg);
		url = "home/index.jsp";//跳转的地址 
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
			//msg用于在页面提示用户相关的操作
					String msg = "";
					if(result >=1){
						msg = "更新成功";
					}else{
						msg = "更新失败";
					}
					request.setAttribute("msg", msg);
					url = "home/index.jsp";//跳转的地址 

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
