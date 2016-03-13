package com.cardpay.pccims.util;

import java.util.List;

import javafx.css.PseudoClass;

public class PageView {

	/**
	 * 排列规则
	 */
	private String orderby;
	
	/**
	 * 分页数据
	 */
	private List<?> records;
	
	/**
	 * 总页数是计算出来的
	 */
	private long pageCount;
	
	/**
	 * 每页显示几条记录
	 */
	private int pageSize = 10;
	
	/**
	 * 动态计算，默认当前页为第一页  
	 */
	private int pageNow = 1;
	
	/**
	 * 总记录数
	 */
	private long rowCount;
	
	/**
	 * 从第几条记录开始
	 */
	private int startPage;
	
	/**
	 * 默认显示10个页码
	 */
	private int pageCode = 10;
	
	public PageView() {
		
	}
	
	/**
	 * 要获得记录的开始索引
	 * @return
	 */
	public int getFirstResult() {
		return (this.pageNow -1) * this.pageSize;
	}
	
	public int getPageCode() {
		return pageCode;
	}
	
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	
	/**
	 * 使用构造函数，强制必须每页显示数量和当前页
	 * @param pageSize 每页显示数量
	 * @param pageNow 当前页
	 */
	public PageView(int pageSize, int pageNow){
		this.pageSize = pageSize;
		this.pageNow = pageNow;
	}
	
	/**
	 * 使用构造函数，强制必须输入当前页
	 * @param pageNow
	 */
	public PageView(int pageNow) {
		this.pageNow = pageNow;
		startPage = (this.pageNow - 1) * this.pageSize;
	}
	
	/**
	 * 查询结果方法 把　记录数　结果集合　放入到　PageView对象
	 * 
	 * @param rowCount
	 *            总记录数
	 * @param records
	 *            结果集合
	 */

	public void setQueryResult(long rowCount, List<?> records) {
		setRowCount(rowCount);
		setRecords(records);
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
		setPageCount(this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
	}

	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<?> records) {
		this.records = records;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public long getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	@Override
	public String toString() {
		return "PageView [ pageCount=" + pageCount + ", pageSize=" + pageSize + ", pageNow=" + pageNow 
			+ ", rowCount=" + rowCount + ", startPage=" + startPage + ", pagecode=" + pageCode + ",orderby=" + orderby + "]";
	}
	
}

