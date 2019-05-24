package daoInterface;

import vo.StudentVo;

/**
 * 这是一个接口，完成对表的所有方法（增删改查）抽象操作
 * @author Mr DU
 *
 */
public interface StudentIn {
	/*
	 * 增加学生信息（注册使用此方法）
	 * 传入的是一个学生信息的对象
	 * 返回Boolean值代表是否成功
	 * 先将可能出现的异常抛出
	 */
	public boolean insertStudent(StudentVo studentvo) throws Exception;
	/*
	 * 此方法完成登录操作
	 * 传入用户名，密码返回布尔值是否成功
	 */
	public boolean loginStudent(String sname,String password) throws Exception;
	/*
	 * 修改个人信息
	 */
	public boolean updateStudent(StudentVo studentVo,String name) throws Exception;
	/*
	 * 查看个人信息
	 */
	public StudentVo queryStudent(String name)throws Exception;
}
