package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conn {
	String url = "jdbc:mysql://localhost:3306/Sign?useUnicode=true&characterEncoding=utf-8";
	String user = "root";
	String pwd = "980630qaz";
	Connection connection;

	public Conn() {// ���췽�����Ǻ��ļ�����ͬ���ķ�����û�з���ֵ�����ڳ�ʼ����һЩ��Ա����
		try {
			Class.forName("com.mysql.jdbc.Driver");// ͨ�����ּ��ر��˵��࣬����ʱ�Ż������������쳣��1.�൱��˫���ͻ���
			connection = DriverManager.getConnection(url, user, pwd);// 2.�������൱��
																		// ��д����ص�¼��Ϣ����
																		// connect

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // ������Ϊ�쳣���³�����ֹ����

	}

	public ResultSet excuteQuery(String sql) {// С���ź��滹�л������Ƿ��������������壨���幦�����̣���ֻ��С���ŷ������ã���ʾĳһ�εľ���ִ�У�
		ResultSet rs = null;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// 3.�൱�ڴ򿪲�ѯ���ڣ�����sql���
			rs = prep.executeQuery();//4.ִ��sql���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int rs = 0;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			rs = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
