package daoFactory;
/**
 * ������ǹ����࣬ʵ�ֵ��ò���
 * @author Mr DU
 *
 */
import daoInterface.StudentIn;
import daoProxy.StudentPo;
public class StudentFy {
	public static StudentIn getFactoryStudent() {
		return new StudentPo();//��̬����ʽ�����ش���ӿ���Ķ���
	}
}
