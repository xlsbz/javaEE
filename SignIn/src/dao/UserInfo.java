package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conn.Conn;
import entity.Meeting;
import entity.User;
import page.PageInfo;

public class UserInfo {
	Conn conn;
	public UserInfo() {
		super();
		conn = new Conn();
	}
	public List<User> getAllUser(){//查询所有管理员信息
		List<User> userinfo = new ArrayList<User>();
		ResultSet rs = conn.excuteQuery("select * from workerinformation");
		try {
			while(rs.next()) {
				String wiID = rs.getString(1);
				String admID = rs.getString(2);
				String wiName = rs.getString(3);
				String wiSex = rs.getString(4);
				String wiGrade = rs.getString(5);
				String wiPsd = rs.getString(6);
				String wiAddress = rs.getString(7);
				String wiPhone = rs.getString(8);
				String wiBorthday = rs.getString(9);
				 User user = new User( wiID,  admID,  wiName,  wiSex,  wiGrade,  wiPsd, wiAddress, wiPhone, wiBorthday );   
				 userinfo.add(user);
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userinfo;
	}
	
	public List<User> getbyId(String wiID) {
		List<User> userinfo = new ArrayList<User>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from workerinformation  where wi_id = '" + wiID + "'");
		try {
			while (rs.next()) {// 如果结果集还有下一行
				 wiID = rs.getString(1);
				String admID = rs.getString(2);
				String wiName = rs.getString(3);
				String wiSex = rs.getString(4);
				String wiGrade = rs.getString(5);
				String wiPsd = rs.getString(6);
				String wiAddress = rs.getString(7);
				String wiPhone = rs.getString(8);
				String wiBorthday = rs.getString(9);
				// 将数据库取得值，对应的保存到student对象的属性
				 User user = new User( wiID,  admID,  wiName,  wiSex,  wiGrade,  wiPsd, wiAddress, wiPhone, wiBorthday );   
			    userinfo.add(user);// 将单个student对象装入 student list集合
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userinfo;
	}
	
	public List<User> getAllUserByPage(PageInfo pageInfo ){
		String itemCount = "0";
		String sqlCount = "select count(*) from workerinformation";//统计总记录
		ResultSet rscount = conn.excuteQuery(sqlCount);
		try {
			if(rscount.next()){//因为统计只会产生1条记录所有if 就够了 不需要 while
				 itemCount =   rscount.getString(1);
				 pageInfo.setItemCount(itemCount);
				 //在这个地方将数据库查询出来的值，这句代码和 setAttribute（"pageInfo",pageInfo）也就给网页了
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<User> userInfo = new ArrayList<User>();
		String sql = "select * from workerinformation limit " + pageInfo.getFirstResult() + "," +pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while(rs.next()) {
				String wiID = rs.getString(1);
				String admID = rs.getString(2);
				String wiName = rs.getString(3);
				String wiSex = rs.getString(4);
				String wiGrade = rs.getString(5);
				String wiPsd = rs.getString(6);
				String wiAddress = rs.getString(7);
				String wiPhone = rs.getString(8);
				String wiBorthday = rs.getString(9);
				 User user = new User( wiID,  admID,  wiName,  wiSex,  wiGrade,  wiPsd, wiAddress, wiPhone, wiBorthday );   
				 userInfo.add(user);
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public int addUserInfo(User user) {
		String sql = "insert into workerinformation values('"+
				user.getWiID()+"','"+
				user.getAdmID()+"','"+
				user.getWiName()+"','"+
				user.getWiSex()+"','"+
				user.getWiGrade()+"','"+
				user.getWiPsd()+"','"+
				user.getWiAddress()+"','"+
				user.getWiPhone()+"','"+
				user.getWiBorthday()+"'"
				+")";
			System.out.println(sql);//用于检查错误
			return conn.executeUpdate(sql);//返回操作数据表作用到的行数目
		}
	public int updateUserInfo(User user) {
		String sql = "update workerinformation set adm_Id = '"+user.getAdmID()+"',"
				+ "wi_Name = '"
				+user.getWiName()+"',wi_Sex = '"
				+user.getWiSex() +"',wi_Grade = '"
				+user.getWiGrade() +"',wi_Psd = '"
				+user.getWiPsd() +"',wi_Address = '"
				+user.getWiAddress() +"',wi_Phone = '"
				+user.getWiPhone() +"',wi_Borthday = '"
				+user.getWiBorthday()+"' where wi_Id"+"='"+user.getWiID()+"'";
		int flag = 0;
		//System.out.println(sql);
		flag = conn.executeUpdate(sql);
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserInfo().getAllUser();
	}
}
