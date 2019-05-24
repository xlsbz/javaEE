package com.dhr.web.domain;

import java.util.List;
/**
 * ��ҳ����
 * @author Mr DU
 *
 * @param <T>
 */
public class PageBean<T> {
	private List<T> data;//��ǰҳ���� limit (pageNumber-1)*pageSize,pageSize
	private int pageNumber;//��ǰҳ��
	private int totalRecord;//�ܼ�¼  count(*)
	private int pageSize;//ÿҳ��¼
	@SuppressWarnings("unused")
	private int totalPage;//��ҳ�� (int)Math.ceil(totalRecord*1.0/pageSize);
	
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
