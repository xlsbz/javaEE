package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import entity.Admin;
import entity.Meeting;
import entity.Usersign;
import page.PageInfo;

public class UsersignInfo {
	Conn conn;
	public UsersignInfo() {
		super();
		conn = new Conn();
	}
	//有关会议信息的实例方法
	public List<Usersign> getAllUsersign(){//查询所有管理员信息
		List<Usersign> UsersignInfo = new ArrayList<Usersign>();
		ResultSet rs = conn.excuteQuery("select * from signuser");
		try {
			while(rs.next()) {
				String userId = rs.getString(1);
				String userName = rs.getString(2);              
			    String userDeparent = rs.getString(3);           
			    String userAdress = rs.getString(4);            
			    String userTime = rs.getString(5);  
			    String userState = rs.getString(6);  
			    System.out.println(userId+""+userName+""+userDeparent+""+userAdress+""+userTime+""+userState+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Usersign usersign = new Usersign(userId, userName, userDeparent, userAdress, userTime, userState);
			    UsersignInfo.add(usersign);//将单个admin对象装入  admsInfo集合
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsersignInfo;
	}
	public List<Usersign> getAllUsersignByPage(PageInfo pageInfo ){
		String itemCount = "0";
		String sqlCount = "select count(*) from signuser";//统计总记录
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
		List<Usersign> UsersignInfo = new ArrayList<Usersign>();
		String sql = "select * from signuser limit " + pageInfo.getFirstResult() + "," +pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while(rs.next()) {
				String userId = rs.getString(1);
				String userName = rs.getString(2);              
			    String userDeparent = rs.getString(3);           
			    String userAdress = rs.getString(4);            
			    String userTime = rs.getString(5);  
			    String userState = rs.getString(6);  
			    System.out.println(userId+""+userName+""+userDeparent+""+userAdress+""+userTime+""+userState+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Usersign usersign = new Usersign(userId, userName, userDeparent, userAdress, userTime, userState);
			    UsersignInfo.add(usersign);//将单个admin对象装入  admsInfo集合
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsersignInfo;
	}
	
	public List<Usersign> getUsersignByType(String mType2) {//通过管理员账号获取管理员信息
		List<Usersign> UsersignInfo = new ArrayList<Usersign>();
		ResultSet rs = conn.excuteQuery("select * from signuser WHERE m_type = '" + mType2+"'" );
		try {
			while(rs.next()) {
				String userId = rs.getString(1);
				String userName = rs.getString(2);              
			    String userDeparent = rs.getString(3);           
			    String userAdress = rs.getString(4);            
			    String userTime = rs.getString(5);  
			    String userState = rs.getString(6);  
			    System.out.println(userId+""+userName+""+userDeparent+""+userAdress+""+userTime+""+userState+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Usersign usersign = new Usersign(userId, userName, userDeparent, userAdress, userTime, userState);
			    UsersignInfo.add(usersign);//将单个admin对象装入  admsInfo集合
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsersignInfo;
	}
	public int addSignUserInfo(Usersign usersigns) {
		String sql = "insert into signuser values('"+
				usersigns.getUserId()+"','"+
				usersigns.getUserName()+"','"+
				usersigns.getUserDeparent()+"','"+
				usersigns.getUserAdress()+"','"+
				usersigns.getUserTime()+"','"+
				usersigns.getUserState()+"'"
				+")";
			//System.out.println(sql);//用于检查错误
			return conn.executeUpdate(sql);//返回操作数据表作用到的行数目
		}
	public int updateMeetingInfo(Meeting meeting) {
        
		//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		//		UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
		//		WHERE LastName = 'Wilson';
		String sql = "update meeting set m_type = '"
				+meeting.getmType()+"',m_time = '"
				+meeting.getmTime() +"',m_address = '"
				+meeting.getmAddress()+"',m_state = '"
				+meeting.getmState()+"' where m_name"+"='" + meeting.getmName()+"'";
		int flag = 0;
	
		//System.out.println(sql);
		flag = conn.executeUpdate(sql);
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UsersignInfo().getAllUsersign();
	}

}
