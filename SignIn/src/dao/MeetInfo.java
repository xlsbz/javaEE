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
	//�йػ�����Ϣ��ʵ������
	public List<Meeting> getAllMeeting(){//��ѯ���й���Ա��Ϣ
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    metsInfo.add(meeting);//������admin����װ��  admsInfo����
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metsInfo;
	}
	public Meeting getMeetByID() {//ͨ������Ա�˺Ż�ȡ����Ա��Ϣ
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
			   //apply.add(apply);//������admin����װ��  admsInfo����
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meeting;
	}
	
	public List<Meeting> getbyId(String admId) {
		List<Meeting> meeting = new ArrayList<Meeting>();// ����һ���յ�student list����
		ResultSet rs = conn.excuteQuery("select * from meeting  where adm_id = '" + admId + "'");
		try {
			while (rs.next()) {// ��������������һ��
				String mType = rs.getString(1);
				String mTime = rs.getString(2);              
			    String mAddress = rs.getString(3);           
			    String mState = rs.getString(4);            
			    String mName = rs.getString(5);  
			    admId = rs.getString(6);  

				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
			    Meeting meetings = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    meeting.add(meetings);// ������student����װ�� student list����
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
		String sqlCount = "select count(*) from meeting";//ͳ���ܼ�¼
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    MeetingsInfo.add(meeting);//������admin����װ��  admsInfo����
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MeetingsInfo;
	}
	public List<Meeting> getMeeting(String mName2) {//ͨ���������ƻ�ȡ����Ա��Ϣ
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    metsInfo.add(meeting);//������admin����װ��  admsInfo����
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metsInfo;
	}
	public List<Meeting> getMeetingByType(String mType2) {//ͨ������Ա�˺Ż�ȡ����Ա��Ϣ
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Meeting meeting = new Meeting(mType, mTime, mAddress, mState, mName, admId);
			    metsInfo.add(meeting);//������admin����װ��  admsInfo����
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
		new MeetInfo().getAllMeeting();
	}

}
