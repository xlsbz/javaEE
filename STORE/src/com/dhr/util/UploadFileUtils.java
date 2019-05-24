package com.dhr.util;

import java.util.Random;
import java.util.UUID;

/**
 * 文件上传所需
 * @author Mr DU
 *
 */
public class UploadFileUtils {
	/**
	 * 获取文件真实名  去掉盘符  直接获取 如1.jpg
	 * @param name
	 * @return
	 */
	public static String getRealName(String name) {
		//查找最后一个/出现的位置
		int index = name.lastIndexOf("\\");
		return name.substring(index+1);
	}
	
	/**
	 * 获取随机名称
	 * @param name
	 * @return
	 */
	public static String UUIDName(String realname) {
		//查找最后一个.出现的位置
		int index = realname.lastIndexOf(".");
		if(index==-1) {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}else {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase()+realname.substring(index);
		}
	}
	
	/**
	 * 返回一个16*16的二级目录
	 * @return
	 */
	public static String dir() {
		String dir = "1234567890abcdefg";
		Random random = new Random();
		return "/"+dir.charAt(random.nextInt(16))+"/"+dir.charAt(random.nextInt(16));
	}
}
