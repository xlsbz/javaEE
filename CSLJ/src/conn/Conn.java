package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 本类用于数据库连接，操作等
 * @author Mr DU
 *
 */
public class Conn {
	private static final String DBDriver = "com.mysql.jdbc.Driver";
	private static final String DBUrl = "jdbc:mysql://localhost:3306/cs_job?useUnicode=true&characterEncoding=utf8";
	private static final String DBUser = "root";
	private static final String DBPassword = "980630qaz";
	//声明数据库操作对象
	private Connection conn = null;
	public Conn() {
		try {
			Class.forName(DBDriver);//加载mysql驱动
			conn = DriverManager.getConnection(DBUrl,DBUser,DBPassword);//相当于打开数据库查询窗口
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//用于数据库连接，返回的是数据库连接对象。
	public Connection getConnection() {
		return this.conn;
	}
	//数据库关闭操作
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
