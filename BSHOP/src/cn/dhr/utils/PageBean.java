package cn.dhr.utils;
/**
 * ��ҳ
 * @author Mr DU
 * 1.ÿҳ��ʾ����List
 * 2.���ǵڼ�ҳ pageNumber
 * 3.һ������ҳ
 * 4.ÿҳ����������
 * 5.һ������������
 */

import java.util.List;

public class PageBean<T> {
	private List<T> data;
	private Integer pageNumber;//�ڼ�ҳ
	private Integer pageNumberTotal;//һ������ҳ
	private Integer pageData;//ÿҳ����������
	private Integer pageDataTotal;//һ������������
	private Integer startIndex;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public void setPageNumberTotal(Integer pageNumberTotal) {
		this.pageNumberTotal = pageNumberTotal;
	}
	//һ������ҳ----������/ÿҳ��������
	public int getPageNumberTotal() {
		return (int) Math.ceil((pageDataTotal*1.0)/pageData);
	}
	//�Ӷ��������ݿ�ʼ --->ǰ����ҳ*ÿҳ���ݸ���
	public int getStartIndex() {
		return (pageNumber-1)*pageData;
	}
	public Integer getPageData() {
		return pageData;
	}
	public void setPageData(Integer pageData) {
		this.pageData = pageData;
	}
	public Integer getPageDataTotal() {
		return pageDataTotal;
	}
	public void setPageDataTotal(Integer pageDataTotal) {
		this.pageDataTotal = pageDataTotal;
	}
	public PageBean(Integer pageNumber, Integer pageData) {
		super();
		this.pageNumber = pageNumber;
		this.pageData = pageData;
	}
	
	
}
