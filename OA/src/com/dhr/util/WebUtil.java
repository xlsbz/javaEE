package com.dhr.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtil {
	private static String numberFilePath;// number.txt的真实路径
	static {
		URL url = WebUtil.class.getClassLoader().getResource("number.txt");
		numberFilePath = url.getPath();// 不要把Tomcat装在有空格或中文的目录下
	}

	/**
	 * 把请求参数封装到JavaBean中，前提表单的字段名和JavaBean属性保持一致
	 * 
	 * @param request
	 * @param clazz
	 *            目标类型
	 * @return
	 */
	public static <T> T fillBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			// 注册日期类型转换器:
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 生成一个唯一的编号:yyyyMMdd00000001 20150210 00000001
	public synchronized static String genApplyNumber() {

		try {
			// 读取number.txt文件，获得当前的编号
			InputStream in = new FileInputStream(numberFilePath);
			byte data[] = new byte[in.available()];
			in.read(data);
			in.close();
			String count = new String(data);// 1
			// 按照约定组织成申请编号，返回
			// ----------------------
			Date now = new Date();
			String prefix = new SimpleDateFormat("yyyyMMdd").format(now);// 20150210
			// ---------------------
			StringBuffer sb = new StringBuffer(prefix);
			for (int i = 0; i < (8 - count.length()); i++) {
				sb.append("0");
			}
			sb.append(count);
			// 加1后，写入number.txt文件
			OutputStream out = new FileOutputStream(numberFilePath);
			out.write((Integer.parseInt(count) + 1 + "").getBytes());
			out.close();

			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(genApplyNumber());
		}
	}
}
