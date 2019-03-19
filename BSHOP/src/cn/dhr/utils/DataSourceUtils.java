package cn.dhr.utils;
/**
 * �������ӳ�
 * @author Mr DU
 *
 */

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	//�ѵ�ǰ���Ӻ��̰߳�
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	//��ȡһ�����ӳض���
	public static DataSource getDataSouerce() {
		return ds;
	}
	//���һ������
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if(con!=null) {
			return con;
		}
		con = ds.getConnection();
		return con;
	}
	
	//��������
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if(con!=null)throw new SQLException("�Ѿ����������ˣ�");
		con = getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}
	//�ύ����
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if(con==null)throw new SQLException("����û�п��������ύ��");
		con.commit();
		con.close();
		tl.remove();
	}
	//�ع�����
	public static void rollbackTransaction() throws SQLException{
		Connection con = tl.get();
		if(con==null)throw new SQLException("û�������������ܻع�");
		con.rollback();
		con.close();
		tl.remove();
	}
	
	//�ͷ�����
	public static void closeTransaction(Connection connection) throws SQLException {
		//��ȡ�����̵߳�con
		Connection con = tl.get();
		//���conΪ�գ���������ר�õģ��͹رմ���������
		if(con==null)connection.close();
		//�����Ϊ�գ��ж��ǲ���������񣬲��Ǿ͹ر�
		if(con!=connection)connection.close();
	}
}
