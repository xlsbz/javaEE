package cn.dhr.utils;
/**
 * 分页
 * @author Mr DU
 * 1.每页显示数据List
 * 2.这是第几页 pageNumber
 * 3.一共多少页
 * 4.每页多少条数据
 * 5.一共多少条数据
 */

import java.util.List;

public class PageBean<T> {
	private List<T> data;
	private Integer pageNumber;//第几页
	private Integer pageNumberTotal;//一共多少页
	private Integer pageData;//每页多少条数据
	private Integer pageDataTotal;//一共多少条数据
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
	//一共多少页----总数据/每页多少数据
	public int getPageNumberTotal() {
		return (int) Math.ceil((pageDataTotal*1.0)/pageData);
	}
	//从多少条数据开始 --->前多少页*每页数据个数
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
