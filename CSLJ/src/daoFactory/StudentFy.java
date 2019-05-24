package daoFactory;
/**
 * 这个类是工厂类，实现调用操作
 * @author Mr DU
 *
 */
import daoInterface.StudentIn;
import daoProxy.StudentPo;
public class StudentFy {
	public static StudentIn getFactoryStudent() {
		return new StudentPo();//多态的形式。返回代理接口类的对象。
	}
}
