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
 * @author ����������Ϣ�Ŀ�����
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
		PrintWriter out = response.getWriter();// �������ã�
		String option = request.getParameter("option");// request�����û������û��ύ�����ݣ�������������ύ��
		switch (option) {
		case "getAllUser":
			getAllUser(request);
			break;
		case "getAllUserByPage":
			getAllUser(request);
			break;
		case "getUser":// ͨ���������Ʋ�ѯ������Ϣ
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
		PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
		pageInfo.setMaxResults("8");
		List<User> users = userInfo.getAllUserByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("users", users);//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
	}
	public void getbyId(HttpServletRequest request ){
		String firstResult =  request.getParameter("firstResult");
		PageInfo pageInfo = new PageInfo();//����û�û����д��ȷ�Ĳ�������Ĭ�ϵ���һҳ
		if(firstResult == null){
			firstResult = "0";
		}
		pageInfo.setFirstResult(firstResult);//�����û����õ��ĵ�һ���ı�ţ����浽pageInfo�з������������һ����
		pageInfo.setMaxResults("8");
		List<User> user = userInfo.getAllUserByPage(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		String wiId = request.getParameter("wiId");
		List<User> users = userInfo.getbyId(wiId);
		request.setAttribute("users", users);
		url = "home/user/indexuser.jsp";//��ת�ĵ�ַ//students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
	}
	public void getUser(HttpServletRequest request) {
		List<User> users = null;
		request.setAttribute("users", users);// students��һ����java�еı������ϣ�������Ҫ�������浽��ҳ�У���ҳ������ʾ
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
		// msg������ҳ����ʾ�û���صĲ���
		String msg = "";
		if (result >= 1) {
			msg = "���³ɹ�";
		} else {
			msg = "����ʧ��";
		}
		request.setAttribute("msg", msg);
		url = "home/user/indexuser.jsp";// ��ת�ĵ�ַ

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
		// msg������ҳ����ʾ�û���صĲ���
		String msg = "";
		if (result >= 1) {
			msg = "��ӳɹ�";
		} else {
			msg = "���ʧ��";
		}
		request.setAttribute("msg", msg);
		url = "admin/user/worklist.jsp";// ��ת�ĵ�ַ

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
