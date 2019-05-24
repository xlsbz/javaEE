package com.dhr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 开班信息
 * 
 * @author Mr DU
 *
 */
public class Classes implements Serializable {
	private Integer id;
	private String name;// 课程类型_1期
	private Date startDate;// 开班日期
	private Date endDate;// 招生截止日期
	private Integer planNumber;// 计划招收人数
	private Integer number;// 已录取人数
	private Integer actualNumber;// 实际招收人数。录完学籍才能知道
	private String status;// 班级状态。
							// 一旦开班：火热报名中
							// 已录取人数超过了30%：名额已不多
							// 开班了：爆满已开办

	private ClassType classType;// 该班级所属的课程类型

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(Integer planNumber) {
		this.planNumber = planNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getActualNumber() {
		return actualNumber;
	}

	public void setActualNumber(Integer actualNumber) {
		this.actualNumber = actualNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

}
