package daoFactory;
/**
 * 管理员代理接口
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
