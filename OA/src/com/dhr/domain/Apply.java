package com.dhr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 入学申请
 * 
 * @author Mr DU
 *
 */
public class Apply implements Serializable {
	private String number;
	private String title;// 姓名_入学申请
	private Date startDate;// 申请日期
	private Date endDate;
	private Boolean closed;
	private Boolean successed;
	private String status;// 申请状态：
							// 申请审批中：提交了申请就为该状态
							// 申请审批通过：申请通过了，但还没有开始走流程
							// 流程进行中：一但开始流程就为该状态。
							// 申请已关闭：没有成功，但关闭的
							// 申请成功：成功
	private Float totalGrade;// 总得分

	// 存放班级对象
	private Classes classes;// 申请的班级
	// 存放申请人
	private Customer customer;// 申请人
	// 存放自荐信对象
	private ResumeApply resumeApply;
	private BaseTestApply baseTestApply;
	private QuotaApply quotaApply;

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

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public Boolean getSuccessed() {
		return successed;
	}

	public void setSuccessed(Boolean successed) {
		this.successed = successed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(Float totalGrade) {
		this.totalGrade = totalGrade;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ResumeApply getResumeApply() {
		return resumeApply;
	}

	public void setResumeApply(ResumeApply resumeApply) {
		this.resumeApply = resumeApply;
	}

	public BaseTestApply getBaseTestApply() {
		return baseTestApply;
	}

	public void setBaseTestApply(BaseTestApply baseTestApply) {
		this.baseTestApply = baseTestApply;
	}

	public QuotaApply getQuotaApply() {
		return quotaApply;
	}

	public void setQuotaApply(QuotaApply quotaApply) {
		this.quotaApply = quotaApply;
	}

}
