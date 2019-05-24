package com.dhr.web.domain;

import java.util.List;
/**
 * 分页工具
 * @author Mr DU
 *
 * @param <T>
 */
public class PageBean<T> {
	private List<T> data;//当前页数据 limit (pageNumber-1)*pageSize,pageSize
	private int pageNumber;//当前页码
	private int totalRecord;//总记录  count(*)
	private int pageSize;//每页记录
	@SuppressWarnings("unused")
	private int totalPage;//总页数 (int)Math.ceil(totalRecord*1.0/pageSize);
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return (int)Math.ceil(totalRecord*1.0/pageSize);
	}
	public int getStartIndex(){
		return (pageNumber-1)*pageSize;
	}
	
	public PageBean(int pageNumber, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	
}
