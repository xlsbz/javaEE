package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.Conn;
import entity.Apply;
import entity.SignIn;
import page.PageInfo;

/**
 * 
 * @ SignInInfo ǩ��
 * 
 *
 */
public class SignInInfo {
	

	
	
		Conn conn;
		public SignInInfo() {
			super();
			conn = new Conn();
		}
		//�йضԹ���Ա��Ϣ������ʵ������
		
		public List<SignIn> getAllSignIn(){//��ѯ���й���Ա��Ϣ
			List<SignIn> signInfo = new ArrayList<SignIn>();
			ResultSet rs = conn.excuteQuery("select * from sign");
			try {
				while(rs.next()) {
					String signId = rs.getString(1);
					String signNumber = rs.getString(2);              
				    String signAdress = rs.getString(3);           
				    String signTime = rs.getString(4);            
				    String signBeizhu = rs.getString(5);  
				    String admId = rs.getString(6);  
				    //System.out.println(signId+""+signNumber+""+signAdress+""+signTime+""+signBeizhu+""+admId+"");
				  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				    SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				    signInfo.add(signin);//������admin����װ��  admsInfo����
				} 	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public SignIn getSignInByID(){//ͨ������Ա�˺Ż�ȡ����Ա��Ϣ
			ResultSet rs = conn.excuteQuery("select * from sign limit 1");
			SignIn signin = null;
			try {
				if(rs.next()) {
					String signId = rs.getString(1);
					String signNumber = rs.getString(2);              
				    String signAdress = rs.getString(3);           
				    String signTime = rs.getString(4);            
				    String signBeizhu = rs.getString(5);  
				    String admId = rs.getString(6);  
				   signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				   //apply.add(apply);//������admin����װ��  admsInfo����
				} 	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signin;
		}
		public List<SignIn> getAllSignInByPage(PageInfo pageInfo ){
			String itemCount = "0";
			String sqlCount = "select count(*) from sign";//ͳ���ܼ�¼
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
			List<SignIn> signInfo = new ArrayList<SignIn>();
			String sql = "select * from sign limit " + pageInfo.getFirstResult() + "," +pageInfo.getMaxResults();
			ResultSet rs = conn.excuteQuery(sql);
			try {
				while(rs.next()) {
					String signId = rs.getString(1);
					String signNumber = rs.getString(2);              
				    String signAdress = rs.getString(3);           
				    String signTime = rs.getString(4);            
				    String signBeizhu = rs.getString(5);  
				    String admId = rs.getString(6); 
				    System.out.println(signId+""+signNumber+""+signAdress+""+signTime+""+signBeizhu+""+admId+"");
				  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
				    SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				    signInfo.add(signin);//������admin����װ��  admsInfo����
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public List<SignIn> getSignIn(String mName2) {//ͨ���������ƻ�ȡ����Ա��Ϣ
			List<SignIn> signInfo = new ArrayList<SignIn>();
			ResultSet rs = conn.excuteQuery("select * from sign WHERE sign_id = '" + mName2+"'" );
			try {
				while(rs.next()) {
					String signId = rs.getString(1);
					String signNumber = rs.getString(2);              
				    String signAdress = rs.getString(3);           
				    String signTime = rs.getString(4);            
				    String signBeizhu = rs.getString(5);  
				    String admId = rs.getString(6);
				    System.out.println(signId+""+signNumber+""+signAdress+""+signTime+""+signBeizhu+""+admId+"");
					  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
					SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				     signInfo.add(signin);//������admin����װ��  admsInfo����
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public List<SignIn> getSignInByType(String mType2) {//ͨ������Ա�˺Ż�ȡ����Ա��Ϣ
			List<SignIn> signInfo = new ArrayList<SignIn>();
			ResultSet rs = conn.excuteQuery("select * from sign WHERE sign_Number = '" + mType2+"'" );
			try {
				while(rs.next()) {
					String signId = rs.getString(1);
					String signNumber = rs.getString(2);              
				    String signAdress = rs.getString(3);           
				    String signTime = rs.getString(4);            
				    String signBeizhu = rs.getString(5);  
				    String admId = rs.getString(6);
				    System.out.println(signId+""+signNumber+""+signAdress+""+signTime+""+signBeizhu+""+admId+"");
					  //�����ݿ�ȡ��ֵ����Ӧ�ı��浽admin���������
					SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				     signInfo.add(signin);//������admin����װ��  admsInfo����
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public int addSignInfo(SignIn signin) {
			String sql = "insert into sign values('"+
					signin.getSignId()+"','"+
					signin.getSignNumber()+"','"+
					signin.getSignAdress()+"','"+
					signin.getSignTime()+"','"+
					signin.getSignBeizhu()+"','"+
					signin.getAdmId()+"'"
					+")";
				//System.out.println(sql);//���ڼ�����
				return conn.executeUpdate(sql);//���ز������ݱ����õ�������Ŀ
			}
		public int updateSignInInfo(SignIn signin) {
	        
			//UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
			//		UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
			//		WHERE LastName = 'Wilson';
			String sql = "update sign set sign_number = '"
					+signin.getSignNumber()+"',sign_adress = '"
					+signin.getSignAdress() +"',sign_time = '"
					+signin.getSignTime()+"',sign_Beizhu = '"
					+signin.getSignBeizhu()+"'where sign_id"+"='" + signin.getSignId()+"'";
			int flag = 0;
		
			//System.out.println(sql);
			flag = conn.executeUpdate(sql);
			return flag;
		}
		public int deleteSignInInfo(String signId) {
			String sql = "delete from sign where sign_id"+"='" + signId+"'";
			int flag = 0;
			flag = conn.executeUpdate(sql);
			return flag;
		}		
		public int deleteAllWSI() {
			String sql = "delete * from sign";
			int flag = 0;
			flag = conn.executeUpdate(sql);
			return flag;
		}
	

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignInInfo().getAllSignIn();
	}

}
