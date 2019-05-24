package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfo;
import entity.Admin;
import entity.Meeting;
import entity.User;
import page.PageInfo;

/**
 * @author 操作会议信息的控制器
 * @Servlet implementation class MeetingC
 */
@WebServlet("/UserS")

public class UserS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfo userInfo;
	String url;

	public UserS() {
		userInfo = new UserInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();// 这句的作用？
		String option = request.getParameter("option");// request代表用户请求及用户提交的数据（用浏览器传参提交）
		switch (option) {
		case "getAllUser":
			getAllUser(request);
			break;
		case "getAllUserByPage":
			getAllUser(request);
			break;
		case "getUser":// 通过会议名称查询会议信息
			getUser(request);
			break;
		case "getbyId":
			getbyId(request);
			break;
		case "addUserInfo":
			addUserInfo(request);
			break;
		case "updateUserInfo":
			updateUserInfo(request);
			break;
		default:
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void getAllUser(HttpServletRequest request) {
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
		pageInfo.setMaxResults("8");
		List<User> users = userInfo.getAllUserByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("users", users);//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
	}
	public void getbyId(HttpServletRequest request ){
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//如果用户没有填写正确的参数，就默认到第一页
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//将从用户处得到的第一条的编号，保存到pageInfo中方便和其它变量一起传输
		pageInfo.setMaxResults("8");
		List<User> user = userInfo.getAllUserByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		String wiId = request.getParameter("wiId");
		List<User> users = userInfo.getbyId(wiId);
		request.setAttribute("users", users);
		url = "home/user/indexuser.jsp";//跳转的地址//students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
	}
	public void getUser(HttpServletRequest request) {
		List<User> users = null;
		request.setAttribute("users", users);// students是一个在java中的变量集合，我们需要把它保存到网页中，网页才能显示
	}

	public void updateUserInfo(HttpServletRequest request) {
		String wiID = request.getParameter("wiID");
		String admID = request.getParameter("admID");
		String wiName = request.getParameter("wiName");
		String wiSex = request.getParameter("wiSex");
		String wiGrade = request.getParameter("wiGrade");
		String wiPsd = request.getParameter("wiPsd");
		String wiAddress = request.getParameter("wiAddress");
		String wiPhone = request.getParameter("wiPhone");
		String wiBorthday = request.getParameter("wiBorthday");
		User user = new User(wiID, admID, wiName, wiSex, wiGrade, wiPsd, wiAddress, wiPhone, wiBorthday);
		int result = userInfo.updateUserInfo(user);
		request.setAttribute("result", result);
		request.setAttribute("user", user);
		System.out.println(result);
		// msg用于在页面提示用户相关的操作
		String msg = "";
		if (result >= 1) {
			msg = "更新成功";
		} else {
			msg = "更新失败";
		}
		request.setAttribute("msg", msg);
		url = "home/user/indexuser.jsp";// 跳转的地址

	}

	public void addUserInfo(HttpServletRequest request) {
		String wiID = request.getParameter("wiID");
		String admID = request.getParameter("admID");
		String wiName = request.getParameter("wiName");
		String wiSex = request.getParameter("wiSex");
		String wiGrade = request.getParameter("wiGrade");
		String wiPsd = request.getParameter("wiPsd");
		String wiAddress = request.getParameter("wiAddress");
		String wiPhone = request.getParameter("wiPhone");
		String wiBorthday = request.getParameter("wiBorthday");
		User user = new User(wiID, admID, wiName, wiSex, wiGrade, wiPsd, wiAddress, wiPhone, wiBorthday);
		int result = userInfo.addUserInfo(user);
		request.setAttribute("result", result);
		request.setAttribute("user", user);
		System.out.println(result);
		// msg用于在页面提示用户相关的操作
		String msg = "";
		if (result >= 1) {
			msg = "添加成功";
		} else {
			msg = "添加失败";
		}
		request.setAttribute("msg", msg);
		url = "admin/user/worklist.jsp";// 跳转的地址

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
