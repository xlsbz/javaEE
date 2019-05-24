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
	//�йػ�����Ϣ��ʵ������
	public List<Apply> getAllApply(){//��ѯ���й���Ա��Ϣ
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
			  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
			    Apply applys = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
			    applyInfo.add(applys);//������admin����װ��  admsInfo����
			} 	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyInfo;
	}
	
	public List<Apply> getbyId(String applyId) {
		List<Apply> apply = new ArrayList<Apply>();// ����һ���յ�student list����
		ResultSet rs = conn.excuteQuery("select * from apply  where apply_Id = '" + applyId + "'");
		try {
			while (rs.next()) {// ��������������һ��

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
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Apply Apply = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
				apply.add(Apply);// ������student����װ�� student list����
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
		String sqlCount = "select count(*) from apply";// ͳ���ܼ�¼
		ResultSet rscount = conn.excuteQuery(sqlCount);
		try {
			if (rscount.next()) {// ��Ϊͳ��ֻ�����1����¼����if �͹��� ����Ҫ while
				itemCount = rscount.getString(1);
				pageInfo.setItemCount(itemCount);
				// ������ط������ݿ��ѯ������ֵ��������� setAttribute��"pageInfo",pageInfo��Ҳ�͸���ҳ��
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Apply> Applys = new ArrayList<Apply>();// ����һ���յ�student list����
		String sql = "select * from apply limit " + pageInfo.getFirstResult() + ","
				+ pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while (rs.next()) {// ��������������һ��
				
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
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Apply Apply = new Apply(applyId, applyName, applyTimestart, applyTimeend, applyType, applyState,applyInformation,applyAdress,applyWin,applyPhone,applyBeizhu,admId);
				Applys.add(Apply);// ������student����װ�� student list����
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
			System.out.println(sql);//���ڼ�����
			return conn.executeUpdate(sql);//���ز������ݱ����õ�������Ŀ
		}
	public int updateApplyInfo(Apply apply) {
        
		//UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
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
	public Apply getApplyByID() {//ͨ������Ա�˺Ż�ȡ����Ա��Ϣ
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
			   //apply.add(apply);//������admin����װ��  admsInfo����
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
