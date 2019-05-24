package com.dhr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 分配入学名额信息
 * 
 * @author Mr DU
 *
 */
public class QuotaApply implements Serializable {
	private String number;// 入学申请的编号
	private String status;
	// 名额分配中：
	// 通过：
	// 不通过：
	private Date checkDate;
	private String checker;
	private String checkMessage;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckMessage() {
		return checkMessage;
	}

	public void setCheckMessage(String checkMessage) {
		this.checkMessage = checkMessage;
	}

}
