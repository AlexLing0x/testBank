package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 分页Action
 * @author SISV
 *
 */
public class PageAction extends ActionSupport{

	//每页条数
	public static final int PER_PAGE = 10;
	
	//当前页
	private int curPage = 1;
		
	//总页数
	private int totalPage;
	
	//总记录数
	private int totalRows;

	/**
	 * 记算总页数
	 */
	public void init(int totalRows){
		
		this.totalRows = totalRows;
		if(totalRows%PER_PAGE==0){ //能整除
			totalPage = totalRows/PER_PAGE;
		}else{//不能整除
			totalPage = totalRows/PER_PAGE + 1;
		}
		
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	
	
}
