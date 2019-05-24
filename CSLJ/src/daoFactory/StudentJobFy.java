package daoFactory;
/**
 * 工厂类，调用
 * @author Mr DU
 *
 */
import daoInterface.StudentJobIn;
import daoProxy.StudentJobPo;
public class StudentJobFy {
	public static StudentJobIn getStudentJob() {
		return new StudentJobPo();
	}
}
