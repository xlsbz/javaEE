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
 * @ LeaveInfo 请假记录 包含查看请加信息，提交请假信息
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
		//有关对管理员信息操作的实例方法
		
		public List<Leave> getAllLeave(){//查询所有请假信息
			List<Leave> leavesInfo = new ArrayList<Leave>();
			ResultSet rs = conn.excuteQuery("select * from leaveInformation");
			try {
				//String admID;
				//String wiID;多余的一个选项
				while(rs.next()) {
					String leaID = rs.getString(1);   
					String leaDate = rs.getString(2);              
				    String leaTime = rs.getString(3);           
				    String leaState = rs.getString(4);            
				    int leaOrderNum = rs.getInt(5);  
				    String admID = rs.getString(6);
				    String wiID = rs.getString(7);
				    System.out.println(leaID+""+leaDate+""+leaTime+""+leaState+""+leaOrderNum+admID+""+wiID);
				  //将数据库取得值，对应的保存到admin对象的属性
				    Leave leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				    leavesInfo.add(leave);//将单个admin对象装入  admsInfo集合
				} 	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}
		public List<Leave> getLeave(String leaID2) {//通过员工账号获取管理员信息
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
				  //将数据库取得值，对应的保存到admin对象的属性
				     leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				   leavesInfo.add(leave);
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}
		public List<Leave> getLeaveByDate(String leaDate2) {//通过员工账号获取管理员信息
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
				  //将数据库取得值，对应的保存到admin对象的属性
				    Leave leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				    leavesInfo.add(leave);//将单个admin对象装入  admsInfo集合
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return leavesInfo;
		}

		public List<Leave> getAllLeaveByPage(PageInfo pageInfo ){
			
			String itemCount = "0";
			String sqlCount = "select count(*) from leaveInformation";//统计总记录
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
				  //将数据库取得值，对应的保存到admin对象的属性
				    Leave leave = new Leave(leaID, leaDate, leaTime, leaState, leaOrderNum, admID,wiID);
				    leavesInfo.add(leave);//将单个admin对象装入  admsInfo集合
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
				System.out.println(sql);//用于检查错误
				return conn.executeUpdate(sql);//返回操作数据表作用到的行数目
			}
		public int updateLeaveInfo(Leave leave2) {
			        
			//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
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
