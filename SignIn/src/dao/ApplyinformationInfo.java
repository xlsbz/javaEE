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
 * @ SignInInfo ǩ��
 * 
 *
 */
public class ApplyinformationInfo {

	Conn conn;

	public ApplyinformationInfo() {
		super();
		conn = new Conn();
	}
	// �йضԹ���Ա��Ϣ������ʵ������


	public List<Applyinformation> getAllApplyinformation() {// ��ѯ���й���Ա��Ϣ
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
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				Applyinformation applyinformation = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformations.add(applyinformation);// ������admin����װ��
														// admsInfo����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyinformations;
	}
	public List<Applyinformation> getbyNumber(String contNumber) {
		List<Applyinformation> applyinformation = new ArrayList<Applyinformation>();// ����һ���յ�student list����
		ResultSet rs = conn.excuteQuery("select * from signinformation  where cont_number = '" + contNumber + "'");
		try {
			while (rs.next()) {// ��������������һ��
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

				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Applyinformation apply = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformation.add(apply);// ������student����װ�� student list����
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
		String sqlCount = "select count(*) from signinformation";// ͳ���ܼ�¼
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
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				Applyinformation applyinformation = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformations.add(applyinformation);// ������admin����װ��
														// admsInfo����
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyinformations;
	}
	
	public List<Applyinformation> getbyName(String contName) {
		List<Applyinformation> applyinformation = new ArrayList<Applyinformation>();// ����һ���յ�student list����
		ResultSet rs = conn.excuteQuery("select * from signinformation  where cont_name = '" + contName + "'");
		try {
			while (rs.next()) {// ��������������һ��

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
				// �����ݿ�ȡ��ֵ����Ӧ�ı��浽student���������
				Applyinformation applyinformations = new Applyinformation(contId, contName, contSex, contNumber,
						contCard, contSchool, contClass, contPhone, contBeizhu, applyId);
				applyinformation.add(applyinformations);// ������student����װ�� student list����
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
				System.out.println(sql);//���ڼ�����
				return conn.executeUpdate(sql);//���ز������ݱ����õ�������Ŀ
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
