package com.dhr.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4j解耦和
 * @author Mr DU
 *
 */
public class BeanFactory {
	public static Object getBean(String id) {
		try {
			//1.创建解析工厂
			SAXReader reader = new SAXReader();
			//获取document,read读取真实路径
			Document document = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("bean.xml"));
			//2.获取Element
			Element element = (Element)document.selectSingleNode("//bean[@id='"+id+"']");
			//3.反射实例化类
			String classvalue = element.attributeValue("class");
			//4.返回实例化对象
			Object object = Class.forName(classvalue).newInstance();
			return object;
		} catch (Exception e) {
			System.out.println("获取bean出现异常");
			e.printStackTrace();
		}
		return null;
	}
}
