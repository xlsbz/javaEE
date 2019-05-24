package daoInterface;

import vo.StudentVo;

/**
 * ����һ���ӿڣ���ɶԱ�����з�������ɾ�Ĳ飩�������
 * @author Mr DU
 *
 */
public interface StudentIn {
	/*
	 * ����ѧ����Ϣ��ע��ʹ�ô˷�����
	 * �������һ��ѧ����Ϣ�Ķ���
	 * ����Booleanֵ�����Ƿ�ɹ�
	 * �Ƚ����ܳ��ֵ��쳣�׳�
	 */
	public boolean insertStudent(StudentVo studentvo) throws Exception;
	/*
	 * �˷�����ɵ�¼����
	 * �����û��������뷵�ز���ֵ�Ƿ�ɹ�
	 */
	public boolean loginStudent(String sname,String password) throws Exception;
	/*
	 * �޸ĸ�����Ϣ
	 */
	public boolean updateStudent(StudentVo studentVo,String name) throws Exception;
	/*
	 * �鿴������Ϣ
	 */
	public StudentVo queryStudent(String name)throws Exception;
}
