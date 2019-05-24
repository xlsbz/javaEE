package com.dhr.conn;
/**
 * 数据库连接
 * @author Mr DU
 * useUnicode=true&characterEncoding=utf8;保证向数据库写入时不乱码
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
public class Conn {
	private static final String DBDriver = "com.mysql.jdbc.Driver";
	private static final String DBUrl = "jdbc:mysql://localhost:3306/store?useUnicode=true&characterEncoding=utf8";
	private static final String DBUser = "root";
	private static final String DBPassword = "980630qaz";
	Connection conn;

	public Conn() {
		try {
			//反射加载驱动
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//数据库连接
	public Connection getConnection() {
		return this.conn;
	}

	// 关闭数据库
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	public static void closeStatement(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}

	public static void startTransaction() throws SQLException {
		Connection conn = new Conn().getConnection();
		conn.setAutoCommit(false);
	}

	public static void commitAndClose() {
		try {
			Connection conn = new Conn().getConnection();
			conn.commit();
		} catch (SQLException e) {
		}

	}

	public static void rollbackAndClose() {
		try {
			Connection conn = new Conn().getConnection();
			conn.rollback();
		} catch (SQLException e) {
		}

	}
	
}
