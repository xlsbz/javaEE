package com.dhr.domain;
/**
 * 状态信息
 * @author Mr DU
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Msg {

	private Integer code;// 显示返回状态 1：成功 2：失败
	private String msg;// 显示状态信息
	private Map<String, Object> information = new HashMap<>();

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getInformation() {
		return information;
	}

	public void setInformation(Map<String, Object> information) {
		this.information = information;
	}

	// 处理成功
	public static Msg success() {
		Msg msg = new Msg();
		msg.setCode(1);
		msg.setMsg("信息处理成功！");
		return msg;
	}

	// 处
	public static Msg error() {
		Msg msg = new Msg();
		msg.setCode(2);
		msg.setMsg("信息处理失败！");
		return msg;
	}

	// 添加信息
	public Msg add(String key, Object value) {
		this.getInformation().put(key, value);
		return this;
	}
}
