package daoProxy;

import java.sql.Connection;

import conn.Conn;
import daoInterface.StudentIn;
import daoTrue.StudentTu;
import vo.StudentVo;
/**
 * ���Ǵ���ʵ���࣬�����ʵʵ��������飬���������
 * @author Mr DU
 *
 */
public class StudentPo implements StudentIn{
	Conn conn = null;
	StudentTu studentTu = null;
	public StudentPo() {
		//��������ʵ�������ݿ���󣬰����ݿ������Ϊ�βδ�����ʵʵ����
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
