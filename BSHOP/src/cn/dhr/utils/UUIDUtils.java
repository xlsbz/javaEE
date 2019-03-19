package cn.dhr.utils;

import java.util.UUID;

/**
 * 生成随机数
 * @author Mr DU
 *
 */
public class UUIDUtils {
	public static String getUUIDUtils() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
//	public static void main(String[] args) {
//		
//		System.out.println(getUUIDUtils());
//	}
}
