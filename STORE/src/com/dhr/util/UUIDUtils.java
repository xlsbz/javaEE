package com.dhr.util;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 产生随机序列
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	public static String getCode(){
		return getId();
	}
//	
//	public static void main(String[] args) {
//		System.out.println(getId());
//		System.out.println(getCode());
//	}
}
