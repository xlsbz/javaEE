package com.dhr.util;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * ����admin��xml
 * @author Mr DU
 *
 */
public class XMLUtils{
	public static boolean loginAdmin(String name,String pass) {
		//�û����Ƿ���ȷ
		boolean n = false;
		//�û������Ƿ���ȷ
		boolean m = false;
		//��¼״̬
		boolean flag = false;
		try {
			//0.����dom4j xpath����
			//1.��ȡ������
			SAXReader reader = new SAXReader();
			//2.�õ�document
			Document document = reader.read(XMLUtils.class.getClassLoader().getResourceAsStream("admin.xml"));
			//3.��ȡ����ֵ
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
		//4.�ȽϷ���
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
