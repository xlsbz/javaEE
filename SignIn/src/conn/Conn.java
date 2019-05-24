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

	public Conn() {// 构造方法就是和文件和类同名的方法，没有返回值，用于初始化类一些成员变量
		try {
			Class.forName("com.mysql.jdbc.Driver");// 通过名字加载别人的类，运行时才会产生错误叫做异常，1.相当于双击客户端
			connection = DriverManager.getConnection(url, user, pwd);// 2.打开连接相当于
																		// 填写好相关登录信息后点击
																		// connect

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // 不能因为异常导致程序终止运行

	}

	public ResultSet excuteQuery(String sql) {// 小括号后面还有花括号是方法声明方法定义（定义功能流程），只有小括号方法调用（表示某一次的具体执行）
		ResultSet rs = null;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// 3.相当于打开查询窗口，输入sql语句
			rs = prep.executeQuery();//4.执行sql语句
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
