package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import entity.Admin;
import entity.Apply;
import entity.Meeting;
import page.PageInfo;

public class ApplyInfo {
	Conn conn;
	public ApplyInfo() {
		super();
		conn = new Conn();
	}
	//有关会议信息的实例方法
	public List<Apply> getAllApply(){//查询所有管理员信息
		List<Apply> applyInfo = new ArrayList<Apply>();
		ResultSet rs = conn.excuteQuery("select * from apply ");
		try {
			while(rs.next()) {
			
				String applyId = rs.getString(1);
				String applyName = rs.getString(2);              
				String applyTimestart = rs.getString(3);           
				String applyTimeend = rs.getString(4);            
			    String applyType = rs.getString(5);  
			    String applyState = rs.getString(6); 
			    String applyInformation = rs.getString(7);  
			    String applyAdress = rs.getString(8);  
			    String applyWin = rs.getString(9);  
			    String applyPhone = rs.getString(10);  
			    String applyBeizhu = rs.getString(11);  
			    String admId = rs.getString(12);  
			 
			    System.out.println(applyId+""+applyName+""+applyTimestart+""+applyTimeend+""
			    +applyType+""+applyState+""+applyInformation+""+applyAdress+""+applyWin+""+applyPhone+""+applyBeizhu+""+admId);
			  //将数据库取得值，对应的保存到admin对象的属性
			    Apply applys = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
			    applyInfo.add(applys);//将单个admin对象装入  admsInfo集合
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyInfo;
	}
	
	public List<Apply> getbyId(String applyId) {
		List<Apply> apply = new ArrayList<Apply>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from apply  where apply_Id = '" + applyId + "'");
		try {
			while (rs.next()) {// 如果结果集还有下一行

				applyId = rs.getString(1);
				String applyName = rs.getString(2);              
				String applyTimestart = rs.getString(3);           
				String applyTimeend = rs.getString(4);            
			    String applyType = rs.getString(5);  
			    String applyState = rs.getString(6); 
			    String applyInformation = rs.getString(7);  
			    String applyAdress = rs.getString(8);  
			    String applyWin = rs.getString(9);  
			    String applyPhone = rs.getString(10);  
			    String applyBeizhu = rs.getString(11);  
			    String admId = rs.getString(12);  
				// 将数据库取得值，对应的保存到student对象的属性
				Apply Apply = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
				apply.add(Apply);// 将单个student对象装入 student list集合
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apply;
	}
	
		
	public List<Apply> getApplyByPage(PageInfo pageInfo) {

		String itemCount = "0";
		String sqlCount = "select count(*) from apply";// 统计总记录
		ResultSet rscount = conn.excuteQuery(sqlCount);
		try {
			if (rscount.next()) {// 因为统计只会产生1条记录所有if 就够了 不需要 while
				itemCount = rscount.getString(1);
				pageInfo.setItemCount(itemCount);
				// 在这个地方将数据库查询出来的值，这句代码和 setAttribute（"pageInfo",pageInfo）也就给网页了
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Apply> Applys = new ArrayList<Apply>();// 声明一个空的student list集合
		String sql = "select * from apply limit " + pageInfo.getFirstResult() + ","
				+ pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while (rs.next()) {// 如果结果集还有下一行
				
				String applyId = rs.getString(1);
				String applyName = rs.getString(2);              
				String applyTimestart = rs.getString(3);           
				String applyTimeend = rs.getString(4);            
			    String applyType = rs.getString(5);  
			    String applyState = rs.getString(6); 
			    String applyInformation = rs.getString(7);  
			    String applyAdress = rs.getString(8);  
			    String applyWin = rs.getString(9);  
			    String applyPhone = rs.getString(10);  
			    String applyBeizhu = rs.getString(11);  
			    String admId = rs.getString(12);  
				// 将数据库取得值，对应的保存到student对象的属性
				Apply Apply = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
				Applys.add(Apply);// 将单个student对象装入 student list集合
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Applys;
	}

	public int addApplyInfo(Apply apply) {
		String sql = "insert into apply values('"+
				apply.getApplyId()+"','"+
				apply.getApplyName()+"','"+
				apply.getApplyTimestart()+"','"+
				apply.getApplyTimeend()+"','"+
				apply.getApplyType()+"','"+
				apply.getApplyState()+"','"+
				apply.getApplyInformation()+"','"+
				apply.getApplyAdress()+"','"+
				apply.getApplyWin()+"','"+
				apply.getApplyPhone()+"','"+
				apply.getApplyBeizhu()+"','"+
				apply.getAdmId()+"'"
				+")";
			System.out.println(sql);//用于检查错误
			return conn.executeUpdate(sql);//返回操作数据表作用到的行数目
		}
	public int updateApplyInfo(Apply apply) {
        
		//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		//		UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
		//		WHERE LastName = 'Wilson';
		String sql = "update apply set adm_id = '"
				+apply.getAdmId()+"',apply_name = '"
				+apply.getApplyName() +"',apply_timestart = '"
				+apply.getApplyTimestart()+"',apply_timeend = '"
				+apply.getApplyTimeend()+"',apply_type = '"
				+apply.getApplyType() +"',apply_state = '"
				+apply.getApplyState()+"',apply_information = '"
			    +apply.getApplyInformation()+"',apply_adress = '"
				+apply.getApplyAdress() +"',apply_win = '"
				+apply.getApplyWin()+"',apply_phone = '"
				+apply.getApplyPhone()+"',apply_beizhu = '"
				+apply.getApplyBeizhu() +"' where apply_id"+"='" + apply.getApplyId()+"'";
		int flag = 0;
	
		System.out.println(sql);
		flag = conn.executeUpdate(sql);
		return flag;
	}
	public Apply getApplyByID() {//通过管理员账号获取管理员信息
		ResultSet rs = conn.excuteQuery("select * from apply limit 1");
		Apply apply = null;
		try {
			if(rs.next()) {
			
				String applyId = rs.getString(1);
				String applyName = rs.getString(2);              
				String applyTimestart = rs.getString(3);           
				String applyTimeend = rs.getString(4);            
			    String applyType = rs.getString(5);  
			    String applyState = rs.getString(6); 
			    String applyInformation = rs.getString(7);  
			    String applyAdress = rs.getString(8);  
			    String applyWin = rs.getString(9);  
			    String applyPhone = rs.getString(10);  
			    String applyBeizhu = rs.getString(11);  
			    String admId = rs.getString(12);  
			   apply = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
			   //apply.add(apply);//将单个admin对象装入  admsInfo集合
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apply;
	}
	public int deleteApplyInfo(String applyId) {
		String sql = "delete from apply where apply_id"+"='" + applyId+"'";
		System.out.println(sql);
		int flag = 0;
		flag = conn.executeUpdate(sql);
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ApplyInfo().getAllApply();
		new ApplyInfo().getApplyByID();
	}

}
