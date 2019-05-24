package com.dhr.util;

import java.util.Random;
import java.util.UUID;

/**
 * �ļ��ϴ�����
 * @author Mr DU
 *
 */
public class UploadFileUtils {
	/**
	 * ��ȡ�ļ���ʵ��  ȥ���̷�  ֱ�ӻ�ȡ ��1.jpg
	 * @param name
	 * @return
	 */
	public static String getRealName(String name) {
		//�������һ��/���ֵ�λ��
		int index = name.lastIndexOf("\\");
		return name.substring(index+1);
	}
	
	/**
	 * ��ȡ�������
	 * @param name
	 * @return
	 */
	public static String UUIDName(String realname) {
		//�������һ��.���ֵ�λ��
		int index = realname.lastIndexOf(".");
		if(index==-1) {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}else {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase()+realname.substring(index);
		}
	}
	
	/**
	 * ����һ��16*16�Ķ���Ŀ¼
	 * @return
	 */
	public static String dir() {
		String dir = "1234567890abcdefg";
		Random random = new Random();
		return "/"+dir.charAt(random.nextInt(16))+"/"+dir.charAt(random.nextInt(16));
	}
}
