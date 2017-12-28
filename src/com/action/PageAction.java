package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳAction
 * @author SISV
 *
 */
public class PageAction extends ActionSupport{

	//ÿҳ����
	public static final int PER_PAGE = 10;
	
	//��ǰҳ
	private int curPage = 1;
		
	//��ҳ��
	private int totalPage;
	
	//�ܼ�¼��
	private int totalRows;

	/**
	 * ������ҳ��
	 */
	public void init(int totalRows){
		
		this.totalRows = totalRows;
		if(totalRows%PER_PAGE==0){ //������
			totalPage = totalRows/PER_PAGE;
		}else{//��������
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
