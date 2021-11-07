/**
 * 
 */
package com.nkt.news.bean;

import java.util.List;

/**
 * Description: 对需要分页页面的数据进行封装 Program Name: PageBean.java Date: 2020年4月16日
 * 
 * @author WangXing
 */
public class PageBean<T> {
	private int currentPage; // 当前页码
	private int totalPages; // 总页数
	private int pageSize; // 每页最多显示记录条数
	private int totalRecords; // 总记录数
	
	private List<T> beanList; // 当前页面需要显示的新闻
	private String url;//URL条件
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		totalPages = totalRecords / pageSize;
		return totalRecords % pageSize == 0 ? totalPages : totalPages + 1;
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}
	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	/**
	 * @return the beanList
	 */
	public List<T> getBeanList() {
		return beanList;
	}
	/**
	 * @param beanList the beanList to set
	 */
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
