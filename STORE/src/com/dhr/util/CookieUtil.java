package com.dhr.util;
/**
 * ͨ�����ƻ�ȡcookie
 * @author Mr DU
 *
 */

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static Cookie getCookieByName(String name,Cookie[] cookie) {
		if(cookie!=null) {
			for(Cookie c:cookie) {
				if(name.equals(c.getName())) {
					return c;
				}
			}		
		}
		return null;
	}
}
