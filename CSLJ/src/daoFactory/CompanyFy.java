package daoFactory;
/**
 * 工厂调用方法
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
