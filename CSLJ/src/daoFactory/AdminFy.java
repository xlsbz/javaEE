package daoFactory;
/**
 * ����Ա����ӿ�
 * @author Mr DU
 *
 */

import daoInterface.AdminIn;
import daoProxy.AdminPo;
public class AdminFy {
	public static AdminIn getAdminInstance() {
		return new AdminPo();
	}
}
