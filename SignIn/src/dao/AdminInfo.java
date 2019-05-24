package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import entity.Admin;
import page.PageInfo;

public class AdminInfo {
	Conn conn;

	public AdminInfo() {
		super();
		conn = new Conn();// new ��ʾ�½�һ����Ķ���
	}

	// �����У���ģ���ж��ٹ��ܾͶ�����ٷ���,�����ķ���ֵһ��ģ��ֻ�����֣��������ͷ���list �������󷵻��Լ������ͣ� dml����ֵint
	public List<Admin> getAllAdmin() {
		List<Admin> Admins = new ArrayList<Admin>();// ����һ���յ�student list����
		ResultSet rs = conn.excuteQuery("select * from adminInfomation");
		try {
			while (rs.next()) {// ��������������һ��

				String admId = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
				String admPhone = rs.getString(6);

				System.out.println(
						admId + "" + admNumber + "" + admPsd + "" + admState + "" + admPower + "" + admPhone + "");
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Admin Admin = new Admin(admId, admNumber, admPsd, admState, admPower, admPhone);
				Admins.add(Admin);// ������student����װ�� student list����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Admins;
	}

	public List<Admin> getAdminByPage(PageInfo pageInfo) {

		String itemCount = "0";
		String sqlCount = "select count(*) from adminInfomation";// ͳ���ܼ�¼
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

		List<Admin> Admins = new ArrayList<Admin>();// ����һ���յ�student list����
		String sql = "select * from adminInfomation limit " + pageInfo.getFirstResult() + ","
				+ pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while (rs.next()) {// ��������������һ��
				String admId = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
				String admPhone = rs.getString(6);

				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Admin Admin = new Admin(admId, admNumber, admPsd, admState, admPower, admPhone);
				Admins.add(Admin);// ������student����װ�� student list����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Admins;
	}
	
	
	public List<Admin> searchStudentByName() {
		return null;
	}


	public List<Admin> getAllAdminByPage(PageInfo pageInfo) {

		String itemCount = "0";
		String sqlCount = "select count(*) from adminInfomation";// ͳ���ܼ�¼
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
		List<Admin> admsInfo = new ArrayList<Admin>();
		String sql = "select * from adminInfomation limit " + pageInfo.getFirstResult() + ","
				+ pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while (rs.next()) {
				String admID = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
				String admPhone = rs.getString(6);
				System.out.println(
						admID + "" + admNumber + "" + admPsd + "" + admState + "" + admPower + "" + admPhone + "");
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				Admin admin = new Admin(admID, admNumber, admPsd, admState, admPower, admPhone);
				admsInfo.add(admin);
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admsInfo;
	}

	public int addAdminInfo(Admin admin) {
		String sql = "insert into adminInfomation values('" +
	admin.getAdmId() + "'," + 
	admin.getAdmNumber() + ",'"+ 
	admin.getAdmPsd() + "','" +
	admin.getAdmState() + "','" +
	admin.getAdmPower() + "','"+
	admin.getAdmPhone() + "')";
		System.out.println(sql);

		return conn.executeUpdate(sql);
	}
	public int updateAdminInfo(Admin admin) {
        
		//UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
		//		UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
		//		WHERE LastName = 'Wilson';
		String sql = "update adminInfomation set adm_psd = '"
				+admin.getAdmPsd()+"',adm_state = '"
				+admin.getAdmState() +"',adm_power = '"
				+admin.getAdmPower() +"',adm_phone = '"
				+admin.getAdmPhone() +"' where adm_id"+"='" + admin.getAdmId()+"'";
		int flag = 0;
		flag = conn.executeUpdate(sql);
		return flag;
	}
	

	public int updateAdminByPwd() {
		return 0;
	}

	public int updateAdminByImgsrc() {
		return 0;
	}
	public int deleteAdminInfo(String adminID) {
		String sql = "delete from adminInfomation where adm_id"+"='" + adminID+"'";
		int flag = 0;
		flag = conn.executeUpdate(sql);
		return flag;
	}
	public int deleteAdminInfo(int adminNumber) {
		String sql = "delete from adminInfomation where adm_number"+"='" + adminNumber+"'";
		int flag = 0;
		flag = conn.executeUpdate(sql);
		return flag;
	}
	public static void main(String[] args) {
		// new AdminInfo().getAllAdminC();
	}

	//��ѯ������������Ľ����
	public List<Admin> getbyphone(String admPhone) {
		List<Admin> admins = new ArrayList<Admin>();// ����һ���յ�student list����
		ResultSet rs = conn.excuteQuery("select * from adminInfomation  where adm_phone = '" + admPhone + "'");
		try {
			while (rs.next()) {// ��������������һ��

				String admId = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
			     admPhone = rs.getString(6);

				System.out.println(
						admId + "" + admNumber + "" + admPsd + "" + admState + "" + admPower + "" + admPhone + "");
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Admin Admin = new Admin(admId, admNumber, admPsd, admState, admPower, admPhone);
				admins.add(Admin);// ������student����װ�� student list����
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}
	
	
}
