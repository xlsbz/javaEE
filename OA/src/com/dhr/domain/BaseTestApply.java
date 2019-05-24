package com.dhr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础测试申请
 * 
 * @author Mr DU
 *
 */
public class BaseTestApply implements Serializable {
	private String number;// 入学申请的编号
	private String title;// XXX_自荐信申请
	private Date upTime;
	private String status;
	// 申请处理中：提交申请后变为此状态
	// 通过：
	// 不通过：
	private Date checkDate;
	private String checker;
	private Float grade;
	private String path;
	private String filename;
	private String oldFilename;
	private String message;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
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

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getOldFilename() {
		return oldFilename;
	}

	public void setOldFilename(String oldFilename) {
		this.oldFilename = oldFilename;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
