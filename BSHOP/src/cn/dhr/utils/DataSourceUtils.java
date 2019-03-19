package cn.dhr.utils;
/**
 * 配置连接池
 * @author Mr DU
 *
 */

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	//把当前连接和线程绑定
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	//获取一个连接池对象
	public static DataSource getDataSouerce() {
		return ds;
	}
	//获得一个链接
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if(con!=null) {
			return con;
		}
		con = ds.getConnection();
		return con;
	}
	
	//开启事务
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if(con!=null)throw new SQLException("已经开启事务了！");
		con = getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}
	//提交事务
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if(con==null)throw new SQLException("事务还没有开启不能提交！");
		con.commit();
		con.close();
		tl.remove();
	}
	//回滚事务
	public static void rollbackTransaction() throws SQLException{
		Connection con = tl.get();
		if(con==null)throw new SQLException("没有事务开启！不能回滚");
		con.rollback();
		con.close();
		tl.remove();
	}
	
	//释放链接
	public static void closeTransaction(Connection connection) throws SQLException {
		//获取事务线程的con
		Connection con = tl.get();
		//如果con为空，则不是事务专用的，就关闭传来的连接
		if(con==null)connection.close();
		//如果不为空，判断是不是这个事务，不是就关闭
		if(con!=connection)connection.close();
	}
}
