package daoFactory;
/**
 * ����������
 * @author Mr DU
 *
 */
import daoInterface.CompanyJobIn;
import daoProxy.CompanyJobPo;
public class CompanyJobFy{
	public static CompanyJobIn getCompanyJobFy() {
		return new CompanyJobPo();
	}
}
