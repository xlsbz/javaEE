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
	//�йػ�����Ϣ��ʵ������
	public List<Usersign> getAllUsersign(){//��ѯ���й���Ա��Ϣ
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Usersign usersign = new Usersign(userId, userName, userDeparent, userAdress, userTime, userState);
			    UsersignInfo.add(usersign);//������admin����װ��  admsInfo����
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsersignInfo;
	}
	public List<Usersign> getAllUsersignByPage(PageInfo pageInfo ){
		String itemCount = "0";
		String sqlCount = "select count(*) from signuser";//ͳ���ܼ�¼
		ResultSet rscount = conn.excuteQuery(sqlCount);
		try {
			if(rscount.next()){//��Ϊͳ��ֻ�����1����¼����if �͹��� ����Ҫ while
				 itemCount =   rscount.getString(1);
				 pageInfo.setItemCount(itemCount);
				 //������ط������ݿ��ѯ������ֵ��������� setAttribute��"pageInfo",pageInfo��Ҳ�͸���ҳ��
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Usersign usersign = new Usersign(userId, userName, userDeparent, userAdress, userTime, userState);
			    UsersignInfo.add(usersign);//������admin����װ��  admsInfo����
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsersignInfo;
	}
	
	public List<Usersign> getUsersignByType(String mType2) {//ͨ������Ա�˺Ż�ȡ����Ա��Ϣ
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Usersign usersign = new Usersign(userId, userName, userDeparent, userAdress, userTime, userState);
			    UsersignInfo.add(usersign);//������admin����װ��  admsInfo����
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
			//System.out.println(sql);//���ڼ�����
			return conn.executeUpdate(sql);//���ز������ݱ����õ�������Ŀ
		}
	public int updateMeetingInfo(Meeting meeting) {
        
		//UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
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
