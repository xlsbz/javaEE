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
 * @ SignInInfo 签到
 * 
 *
 */
public class SignInInfo {
	

	
	
		Conn conn;
		public SignInInfo() {
			super();
			conn = new Conn();
		}
		//有关对管理员信息操作的实例方法
		
		public List<SignIn> getAllSignIn(){//查询所有管理员信息
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
				  //将数据库取得值，对应的保存到admin对象的属性
				    SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				    signInfo.add(signin);//将单个admin对象装入  admsInfo集合
				} 	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public SignIn getSignInByID(){//通过管理员账号获取管理员信息
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
				   //apply.add(apply);//将单个admin对象装入  admsInfo集合
				} 	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signin;
		}
		public List<SignIn> getAllSignInByPage(PageInfo pageInfo ){
			String itemCount = "0";
			String sqlCount = "select count(*) from sign";//统计总记录
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
				  //将数据库取得值，对应的保存到admin对象的属性
				    SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				    signInfo.add(signin);//将单个admin对象装入  admsInfo集合
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public List<SignIn> getSignIn(String mName2) {//通过会议名称获取管理员信息
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
					  //将数据库取得值，对应的保存到admin对象的属性
					SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				     signInfo.add(signin);//将单个admin对象装入  admsInfo集合
				} 
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return signInfo;
		}
		public List<SignIn> getSignInByType(String mType2) {//通过管理员账号获取管理员信息
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
					  //将数据库取得值，对应的保存到admin对象的属性
					SignIn signin = new SignIn(signId, signNumber, signAdress, signTime, signBeizhu, admId);
				     signInfo.add(signin);//将单个admin对象装入  admsInfo集合
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
				//System.out.println(sql);//用于检查错误
				return conn.executeUpdate(sql);//返回操作数据表作用到的行数目
			}
		public int updateSignInInfo(SignIn signin) {
	        
			//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
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
