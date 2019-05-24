package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import entity.Admin;
import entity.Leave;
import page.PageInfo;

/**
 * 
 * @ LeaveInfo ��ټ�¼ �����鿴�����Ϣ���ύ�����Ϣ
 * @author 
 * 
 *
 */

public class LeaveInfo {
	

	
		Conn conn;
		public LeaveInfo() {
			super();
			conn = new Conn();
		}
		//�йضԹ���Ա��Ϣ������ʵ������
		
		public List<Leave> getAllLeave(){//��ѯ���������Ϣ
			List<Leave> leavesInfo = new ArrayList<Leave>();
			ResultSet rs = conn.excuteQuery("select * from leaveInformation");
			try {
				//String admID;
				//String wiID;�����һ��ѡ��
				while(rs.next()) {
					String leaID = rs.getString(1);   
					String leaDate = rs.getString(2);              
				    String leaTime = rs.getString(3);           
				    String leaState = rs.getString(4);            
				    int leaOrderNum = rs.getInt(5);  
				    String admID = rs.getString(6);
				    String wiID = rs.getString(7);
				    System.out.println(leaID+""+leaDate+""+leaTime+""+leaState+""+leaOrderNum+admID+""+wiID);
				  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				    Leave leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				    leavesInfo.add(leave);//������admin����װ��  admsInfo����
				} 	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}
		public List<Leave> getLeave(String leaID2) {//ͨ��Ա���˺Ż�ȡ����Ա��Ϣ
			List<Leave> leavesInfo = new ArrayList<Leave>();
			ResultSet rs = conn.excuteQuery("select * from leaveInformation WHERE lea_id = '" + leaID2+"'" );
			Leave leave = null;
			try {
				while(rs.next()) {
					String leaID = rs.getString(1);   
					String leaDate = rs.getString(2);              
				    String leaTime = rs.getString(3);           
				    String leaState = rs.getString(4);            
				    int leaOrderNum = rs.getInt(5);  
				    String admID = rs.getString(6);
				    String wiID = rs.getString(7);
				    System.out.println(leaID+""+leaDate+""+leaTime+""+leaState+""+leaOrderNum);
				  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				     leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				   leavesInfo.add(leave);
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}
		public List<Leave> getLeaveByDate(String leaDate2) {//ͨ��Ա���˺Ż�ȡ����Ա��Ϣ
			List<Leave> leavesInfo = new ArrayList<Leave>();
			ResultSet rs = conn.excuteQuery("select * from leaveInfomation WHERE lea_date = '" + leaDate2+"'" );
			try {
				while(rs.next()) {
					String leaID = rs.getString(1);   
					String leaDate = rs.getString(2);              
				    String leaTime = rs.getString(3);           
				    String leaState = rs.getString(4);            
				    int leaOrderNum = rs.getInt(5);  
				    String admID = rs.getString(6);
				    String wiID = rs.getString(7);
				    System.out.println(leaID+""+leaDate+""+leaTime+""+leaState+""+leaOrderNum);
				  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				    Leave leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				    leavesInfo.add(leave);//������admin����װ��  admsInfo����
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}

		public List<Leave> getAllLeaveByPage(PageInfo pageInfo ){
			
			String itemCount = "0";
			String sqlCount = "select count(*) from leaveInformation";//ͳ���ܼ�¼
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
			List<Leave> leavesInfo = new ArrayList<Leave>();
			String sql = "select * from leaveInformation limit " + pageInfo.getFirstResult() + "," +pageInfo.getMaxResults();
			ResultSet rs = conn.excuteQuery(sql);
			try {
				while(rs.next()) {
					String leaID = rs.getString(1);   
					String leaDate = rs.getString(2);              
				    String leaTime = rs.getString(3);           
				    String leaState = rs.getString(4);            
				    int leaOrderNum = rs.getInt(5);  
				    String admID = rs.getString(6);
				    String wiID = rs.getString(7);
				    System.out.println(leaID+""+leaDate+""+leaTime+""+leaState+""+leaOrderNum);
				  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				    Leave leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				    leavesInfo.add(leave);//������admin����װ��  admsInfo����
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}
		public int addLeaveInfo(Leave leave) {
			String sql = "insert into adminInformation values('"+
					leave.getLeaID()+"',"+
					leave.getLeaDate()+",'"+
					leave.getLeaTime()+"','"+
					leave.getLeaState()+"','"+
					leave.getLeaOrderNum()+"','"+
					leave.getAdmID()+"','"+
					leave.getWiID()+"'"
					+")";
				System.out.println(sql);//���ڼ�����
				return conn.executeUpdate(sql);//���ز������ݱ����õ�������Ŀ
			}
		public int updateLeaveInfo(Leave leave2) {
			        
			//UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
			//		UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
			//		WHERE LastName = 'Wilson';
			String sql = "update from leaveInformation set lea_state = '"
					//+leave2.getAdmPsd()+",adm_state = '"
					+leave2.getLeaState() //+",adm_power = '"
					//+leave2.getAdmPower() +",adm_phone = '"
					//+leave2.getAdmPhone() 
					+"' where lea_id"+"='" + leave2.getLeaID()+"'";
			int flag = 0;
			flag = conn.executeUpdate(sql);
			return flag;
		}
	 	public int deleteLeaveInfo(String leaveID) {
			String sql = "delete from leaveInfomation where lea_id"+"='" + leaveID+"'";
			int flag = 0;
			flag = conn.executeUpdate(sql);
			return flag;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LeaveInfo().getAllLeave();
	}

}
