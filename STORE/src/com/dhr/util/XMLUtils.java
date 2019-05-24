package com.dhr.util;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 解析admin的xml
 * @author Mr DU
 *
 */
public class XMLUtils{
	public static boolean loginAdmin(String name,String pass) {
		//用户名是否正确
		boolean n = false;
		//用户密码是否正确
		boolean m = false;
		//登录状态
		boolean flag = false;
		try {
			//0.采用dom4j xpath解析
			//1.获取解析器
			SAXReader reader = new SAXReader();
			//2.得到document
			Document document = reader.read(XMLUtils.class.getClassLoader().getResourceAsStream("admin.xml"));
			//3.获取属性值
			@SuppressWarnings("unchecked")
			List<Node> adminname = document.selectNodes("//name");
			@SuppressWarnings("unchecked")
			List<Node> password = document.selectNodes("//password");
			for(Node admin:adminname) {
					if(admin.getText().equals(name)) {
						n = true;
						break;
					}
			}
			for(Node pas:password) {
				if(pas.getText().equals(pass)) {
					m = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//4.比较返回
		if(n&&m) {
			flag = true;
		}
		return flag;
	}
//	public static void main(String[] args) {
//		boolean a = loginAdmin("asd", "2s2");
//		System.out.println(a);
//	}

}
