package daoProxy;

import java.sql.Connection;

import conn.Conn;
import daoInterface.StudentIn;
import daoTrue.StudentTu;
import vo.StudentVo;
/**
 * 这是代理实现类，完成真实实现类的事情，降低耦合性
 * @author Mr DU
 *
 */
public class StudentPo implements StudentIn{
	Conn conn = null;
	StudentTu studentTu = null;
	public StudentPo() {
		//这里是真实链接数据库对象，把数据库对象作为形参传给真实实现类
		conn = new Conn();
		studentTu = new StudentTu(conn.getConnection());
	}
	@Override
	public boolean insertStudent(StudentVo studentvo) throws Exception {
		boolean flag = false;
		flag = studentTu.insertStudent(studentvo);
		conn.close();
		return flag;
	}

	@Override
	public boolean loginStudent(String sname, String password) throws Exception {
		boolean flag = false;
		flag = studentTu.loginStudent(sname, password);
		conn.close();
		return flag;
	}
	@Override
	public boolean updateStudent(StudentVo studentVo,String name) throws Exception {
		boolean flag = false;
		flag = studentTu.updateStudent(studentVo,name);
		conn.close();
		return flag;
	}
	@Override
	public StudentVo queryStudent(String name) throws Exception {
		StudentVo vo = new StudentVo();
		vo = studentTu.queryStudent(name);
		return vo;
	}

}
