package daoFactory;
/**
 * �������÷���
 * @author Mr DU
 *
 */

import daoInterface.CompanyIn;
import daoProxy.CompanyPo;

public class CompanyFy {
	public static CompanyIn getFactoryCompany() {
		return new CompanyPo();
	}
}
