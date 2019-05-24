package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conn.Conn;
import entity.Apply;
import entity.Applyinformation;
import entity.SignIn;
import page.PageInfo;

/**
 * 
 * @ SignInInfo 签到
 * 
 *
 */
public class ApplyinformationInfo {

	Conn conn;

	public ApplyinformationInfo() {
		super();
		conn = new Conn();
	}
	// 有关对管理员信息操作的实例方法


	public List<Applyinformation> getAllApplyinformation() {// 查询所有管理员信息
		List<Applyinformation> applyinformations = new ArrayList<Applyinformation>();
		ResultSet rs = conn.excuteQuery("select * from signinformation");
		try {
			while (rs.next()) {
				String contId = rs.getString(1);
				String contName = rs.getString(2);
				String contSex = rs.getString(3);
				String contNumber = rs.getString(4);
				String contCard = rs.getString(5);
				String contSchool = rs.getString(6);
				String contClass = rs.getString(7);
				String contPhone = rs.getString(8);
				String contBeizhu = rs.getString(9);
				String applyId = rs.getString(10);

				System.out.println(contId + "" + contName + "" + contSex + "" + contNumber + "" + contCard + ""
						+ contSchool + "" + contClass + "" + contPhone + "" + contBeizhu + "" + applyId);
				// 将数据库取得值，对应的保存到admin对象的属性
				Applyinformation applyinformation = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformations.add(applyinformation);// 将单个admin对象装入
														// admsInfo集合
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyinformations;
	}
	public List<Applyinformation> getbyNumber(String contNumber) {
		List<Applyinformation> applyinformation = new ArrayList<Applyinformation>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from signinformation  where cont_number = '" + contNumber + "'");
		try {
			while (rs.next()) {// 如果结果集还有下一行
				String contId = rs.getString(1);
				String contName = rs.getString(2);
				String contSex = rs.getString(3);
				contNumber = rs.getString(4);
				String contCard = rs.getString(5);
				String contSchool = rs.getString(6);
				String contClass = rs.getString(7);
				String contPhone = rs.getString(8);
				String contBeizhu = rs.getString(9);
				String applyId = rs.getString(10);

				// 将数据库取得值，对应的保存到student对象的属性
				Applyinformation apply = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformation.add(apply);// 将单个student对象装入 student list集合
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyinformation;
	}
	public List<Applyinformation> getAllApplyinformationByPage(PageInfo pageInfo) {
		String itemCount = "0";
		String sqlCount = "select count(*) from signinformation";// 统计总记录
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
		List<Applyinformation> applyinformations = new ArrayList<Applyinformation>();
		String sql = "select * from signinformation limit " + pageInfo.getFirstResult() + ","
				+ pageInfo.getMaxResults();
		ResultSet rs = conn.excuteQuery(sql);
		try {
			while (rs.next()) {
				String contId = rs.getString(1);
				String contName = rs.getString(2);
				String contSex = rs.getString(3);
				String contNumber = rs.getString(4);
				String contCard = rs.getString(5);
				String contSchool = rs.getString(6);
				String contClass = rs.getString(7);
				String contPhone = rs.getString(8);
				String contBeizhu = rs.getString(9);
				String applyId = rs.getString(10);

				//System.out.println(contId + "" + contName + "" + contSex + "" + contNumber + "" + contCard + ""
					//	+ contSchool + "" + contClass + "" + contPhone + "" + contBeizhu + "" + applyId);
				// 将数据库取得值，对应的保存到admin对象的属性
				Applyinformation applyinformation = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformations.add(applyinformation);// 将单个admin对象装入
														// admsInfo集合
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyinformations;
	}
	
	public List<Applyinformation> getbyName(String contName) {
		List<Applyinformation> applyinformation = new ArrayList<Applyinformation>();// 声明一个空的student list集合
		ResultSet rs = conn.excuteQuery("select * from signinformation  where cont_name = '" + contName + "'");
		try {
			while (rs.next()) {// 如果结果集还有下一行

				String contId = rs.getString(1);
				contName = rs.getString(2);
				String contSex = rs.getString(3);
				String contNumber = rs.getString(4);
				String contCard = rs.getString(5);
				String contSchool = rs.getString(6);
				String contClass = rs.getString(7);
				String contPhone = rs.getString(8);
				String contBeizhu = rs.getString(9);
				String applyId = rs.getString(10);
				// 将数据库取得值，对应的保存到student对象的属性
				Applyinformation applyinformations = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformation.add(applyinformations);// 将单个student对象装入 student list集合
				//System.out.println("11");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyinformation;
	}

	public int addApplyinformation(Applyinformation applyinformationInfo) {
			String sql = "insert into signinformation values('"+
					applyinformationInfo.getContId()+"','"+
					applyinformationInfo.getContName()+"','"+
					applyinformationInfo.getContSex()+"','"+
					applyinformationInfo.getContNumber()+"','"+
					applyinformationInfo.getContCard()+"','"+
					applyinformationInfo.getContSchool()+"','"+
					applyinformationInfo.getContClass()+"','"+
					applyinformationInfo.getContPhone()+"','"+
					applyinformationInfo.getContBeizhu()+"','"+
					applyinformationInfo.getApplyId()+"'"
					+")";
				System.out.println(sql);//用于检查错误
				return conn.executeUpdate(sql);//返回操作数据表作用到的行数目
	}

	public int updateApplyinformation(Applyinformation applyinformationInfo) {
		String sql = "update signinformation set cont_id = '"
				+applyinformationInfo.getContId()+"',cont_sex = '"
				+applyinformationInfo.getContSex()+"',cont_number = '"
				+applyinformationInfo.getContNumber()+"',cont_card = '"
				+applyinformationInfo.getContCard() +"',cont_school = '"
				+applyinformationInfo.getContSchool()+"',cont_class = '"
			    +applyinformationInfo.getContClass()+"',cont_phone = '"
				+applyinformationInfo.getContPhone() +"',cont_beizhu = '"
				+applyinformationInfo.getContBeizhu()+"' where cont_name"+"='" + applyinformationInfo.getContName()+"'"+" "+"and"+" " +"apply_id"+"='" + applyinformationInfo.getApplyId()+"'";
		int flag = 0;
		System.out.println(sql);
		flag = conn.executeUpdate(sql);
		return flag;
	}

	public int deleteSignInInfo(String signId) {
		return 0;
	}

	public int deleteAllWSI() {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ApplyinformationInfo().getAllApplyinformation();
	}

}
