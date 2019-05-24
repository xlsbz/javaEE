package com.dhr.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j�����
 * @author Mr DU
 *
 */
public class BeanFactory {
	public static Object getBean(String id) {
		try {
			//1.������������
			SAXReader reader = new SAXReader();
			//��ȡdocument,read��ȡ��ʵ·��
			Document document = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("bean.xml"));
			//2.��ȡElement
			Element element = (Element)document.selectSingleNode("//bean[@id='"+id+"']");
			//3.����ʵ������
			String classvalue = element.attributeValue("class");
			//4.����ʵ��������
			Object object = Class.forName(classvalue).newInstance();
			return object;
		} catch (Exception e) {
			System.out.println("��ȡbean�����쳣");
			e.printStackTrace();
		}
		return null;
	}
}
