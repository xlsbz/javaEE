package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �����������ݿ����ӣ�������
 * @author Mr DU
 *
 */
public class Conn {
	private static final String DBDriver = "com.mysql.jdbc.Driver";
	private static final String DBUrl = "jdbc:mysql://localhost:3306/cs_job?useUnicode=true&characterEncoding=utf8";
	private static final String DBUser = "root";
	private static final String DBPassword = "980630qaz";
	//�������ݿ��������
	private Connection conn = null;
	public Conn() {
		try {
			Class.forName(DBDriver);//����mysql����
			conn = DriverManager.getConnection(DBUrl,DBUser,DBPassword);//�൱�ڴ����ݿ��ѯ����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//�������ݿ����ӣ����ص������ݿ����Ӷ���
	public Connection getConnection() {
		return this.conn;
	}
	//���ݿ�رղ���
	public void close() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
