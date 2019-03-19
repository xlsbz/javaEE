package cn.dhr.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * ������еķ������Լ����������ӵ�����
 * ������紫�ݣ���
 * ��ô������أ�
 *   ͨ��DataSourceUtils.getConnection()�õ����ӣ��п������������ӣ�Ҳ��������ͨ�����ӣ�
 *   DataSourceUtils.closeTransaction()��ɶ����ӵ��ͷţ��������ͨ���ӣ��ر�֮��
 * @author cxf
 *
 */
public class TxQueryRunner extends QueryRunner {
	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		 * 1. �õ�����
		 * 2. ִ�и��෽�����������Ӷ���
		 * 3. �ͷ�����
		 * 4. ����ֵ
		 */
		Connection con = DataSourceUtils.getConnection();
		int[] result = super.batch(con, sql, params);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh)
			throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		T result = super.query(con, sql, param, rsh);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh)
			throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		T result = super.query(con, sql, params, rsh);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		T result = super.query(con, sql, rsh, params);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		T result = super.query(con, sql, rsh);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		int result = super.update(con, sql);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		int result = super.update(con, sql, param);
		DataSourceUtils.closeTransaction(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = DataSourceUtils.getConnection();
		int result = super.update(con, sql, params);
		DataSourceUtils.closeTransaction(con);
		return result;
	}
}
