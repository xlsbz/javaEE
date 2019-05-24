package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import entity.Admin;
import entity.Apply;
import entity.Applyinformation;
import entity.Meeting;
import page.PageInfo;

public class MeetInfo {
	Conn conn;
	public MeetInfo() {
		super();
		conn = new Conn();
	}
	//有关会议信息的实例方法
	public List<Meeting> getAllMeeting(){//查询所有管理员信息
		List<Meeting> metsInfo = new ArrayList<Meeting>();
		ResultSet rs = conn.excuteQuery("select * from meeting");
		try {
			while(rs.next()) {
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    String admId = rs.getString(6);  
			   // System.out.println(mType+""+mTime+""+mAddress+""+mState+""+mName+""+admId+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    metsInfo.add(meeting);//将单个admin对象装入  admsInfo集合
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metsInfo;
	}
	public Meeting getMeetByID() {//通过管理员账号获取管理员信息
		ResultSet rs = conn.excuteQuery("select * from meeting limit 1");
		Meeting meeting = null;
		try {
			if(rs.next()) {
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    String admId = rs.getString(6);  
			    meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			   //apply.add(apply);//将单个admin对象装入  admsInfo集合
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meeting;
	}
	
	public List<Meeting> getbyId(String admId) {
		List<Meeting> meeting = new ArrayList<Meeting>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from meeting  where adm_id = '" + admId + "'");
		try {
			while (rs.next()) {// 如果结果集还有下一行
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    admId = rs.getString(6);  

				// 将数据库取得值，对应的保存到student对象的属性
			    Meeting meetings = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    meeting.add(meetings);// 将单个student对象装入 student list集合
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meeting;
	}
	
	public List<Meeting> getAllMeetingByPage(PageInfo pageInfo ){
		String itemCount = "0";
		String sqlCount = "select count(*) from meeting";//统计总记录
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
		List<Meeting> MeetingsInfo = new ArrayList<Meeting>();
		String sql = "select * from meeting limit " + pageInfo.getFirstResult() + "," +pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while(rs.next()) {
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    String admId = rs.getString(6);  
			    System.out.println(mType+""+mTime+""+mAddress+""+mState+""+mName+""+admId+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    MeetingsInfo.add(meeting);//将单个admin对象装入  admsInfo集合
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MeetingsInfo;
	}
	public List<Meeting> getMeeting(String mName2) {//通过会议名称获取管理员信息
		List<Meeting> metsInfo = new ArrayList<Meeting>();
		ResultSet rs = conn.excuteQuery("select * from metting WHERE m_name = '" + mName2+"'" );
		try {
			while(rs.next()) {
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    String admId = rs.getString(6);  
			    System.out.println(mType+""+mTime+""+mAddress+""+mState+""+mName+""+admId+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    metsInfo.add(meeting);//将单个admin对象装入  admsInfo集合
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metsInfo;
	}
	public List<Meeting> getMeetingByType(String mType2) {//通过管理员账号获取管理员信息
		List<Meeting> metsInfo = new ArrayList<Meeting>();
		ResultSet rs = conn.excuteQuery("select * from meeting WHERE m_type = '" + mType2+"'" );
		try {
			while(rs.next()) {
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    String admId = rs.getString(6);  
			    System.out.println(mType+""+mTime+""+mAddress+""+mState+""+mName+""+admId+"");
			  //将数据库取得值，对应的保存到admin对象的属性
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    metsInfo.add(meeting);//将单个admin对象装入  admsInfo集合
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metsInfo;
	}
	public int addMeetingInfo(Meeting meeting) {
		String sql = "insert into meeting values('"+
				meeting.getmType()+"','"+
				meeting.getmTime()+"','"+
				meeting.getmAddress()+"','"+
				meeting.getmState()+"','"+
				meeting.getmName()+"','"+
				meeting.getAdmId()+"'"
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
		new MeetInfo().getAllMeeting();
	}

}
