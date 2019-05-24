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
		conn = new Conn();// new 表示新建一个类的对象
	}

	// 需求中，该模块有多少功能就定义多少方法,方法的返回值一个模块只有三种，多个对象就返回list 单个对象返回自己的类型， dml返回值int
	public List<Admin> getAllAdmin() {
		List<Admin> Admins = new ArrayList<Admin>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from adminInfomation");
		try {
			while (rs.next()) {// 如果结果集还有下一行

				String admId = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
				String admPhone = rs.getString(6);

				System.out.println(
						admId + "" + admNumber + "" + admPsd + "" + admState + "" + admPower + "" + admPhone + "");
				// 将数据库取得值，对应的保存到student对象的属性
				Admin Admin = new Admin(admId, admNumber, admPsd, admState, admPower, admPhone);
				Admins.add(Admin);// 将单个student对象装入 student list集合
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Admins;
	}

	public List<Admin> getAdminByPage(PageInfo pageInfo) {

		String itemCount = "0";
		String sqlCount = "select count(*) from adminInfomation";// 统计总记录
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

		List<Admin> Admins = new ArrayList<Admin>();// 声明一个空的student list集合
		String sql = "select * from adminInfomation limit " + pageInfo.getFirstResult() + ","
				+ pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while (rs.next()) {// 如果结果集还有下一行
				String admId = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
				String admPhone = rs.getString(6);

				// 将数据库取得值，对应的保存到student对象的属性
				Admin Admin = new Admin(admId, admNumber, admPsd, admState, admPower, admPhone);
				Admins.add(Admin);// 将单个student对象装入 student list集合
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
		String sqlCount = "select count(*) from adminInfomation";// 统计总记录
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
				// 将数据库取得值，对应的保存到admin对象的属性
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
        
		//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
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

	//查询多个满足条件的结果集
	public List<Admin> getbyphone(String admPhone) {
		List<Admin> admins = new ArrayList<Admin>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from adminInfomation  where adm_phone = '" + admPhone + "'");
		try {
			while (rs.next()) {// 如果结果集还有下一行

				String admId = rs.getString(1);
				int admNumber = rs.getInt(2);
				String admPsd = rs.getString(3);
				String admState = rs.getString(4);
				String admPower = rs.getString(5);
			     admPhone = rs.getString(6);

				System.out.println(
						admId + "" + admNumber + "" + admPsd + "" + admState + "" + admPower + "" + admPhone + "");
				// 将数据库取得值，对应的保存到student对象的属性
				Admin Admin = new Admin(admId, admNumber, admPsd, admState, admPower, admPhone);
				admins.add(Admin);// 将单个student对象装入 student list集合
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}
	
	
}
