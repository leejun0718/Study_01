package com.fastcampus.ch4.domain;

import java.util.Iterator;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
//	private int page; // ���� ������
//	private int pageSize; // �� �������� ũ��
//	private String option;
//	private String keyword;
	private SearchCondition sc;
	
	private int totalCnt; // �� �Խù� ����
	private int navSize = 10; // ������ ������̼��� ũ��
	private int totalPage; // ��ü �������� ����
	private int beginPage; // ������̼��� ù��° ������
	private int endPage; // ������̼��� ������ ������
	private boolean showPrev; // ������������ �̵��ϴ� ��ũ�� ������ ������ ����
	private boolean showNext; // ������������ �̵��ϴ� ��ũ�� ������ ������ ����

	public PageHandler(int totalCnt,SearchCondition sc) {
		this.totalCnt = totalCnt;
		this.sc = sc; 
		doPaging(totalCnt,sc);
	}
	
//	public PageHandler(int totalCnt , int page) {
//		this.totalCnt =totalCnt;
//		this.page = page;
//		this.pageSize = 10;
//		totalPage = (int)Math.ceil(totalCnt /(double)pageSize);
//		beginPage =(page-1)/ navSize * navSize + 1;
//		endPage = Math.min(beginPage + navSize-1, totalPage);
//		showPrev = beginPage !=1;
//		showNext = endPage !=totalCnt;
//	}
//	
//	public PageHandler(int totalCnt, int page, int pageSize) {
//		this.totalCnt = totalCnt;
//		this.page = page;
//		this.pageSize = pageSize;
//		totalPage = (int)Math.ceil(totalCnt / (double)pageSize);
//		beginPage = (page-1) / navSize * navSize + 1;
//		endPage = Math.min(beginPage + navSize-1, totalPage);
//		showPrev = beginPage !=1;
//		showNext = endPage !=totalCnt;
//	}
	public void doPaging(int totalCnt,SearchCondition sc) {
	this.totalCnt = totalCnt;

	totalPage = (int)Math.ceil(totalCnt / (double)sc.getPageSize());
	beginPage = (sc.getPage()-1) / navSize * navSize + 1;
	endPage = Math.min(beginPage + navSize-1, totalPage);
	showPrev = beginPage !=1;
	showNext = endPage !=totalCnt;
}
	
	public void print() {
		System.out.println("page = " + sc.getPage());
		System.out.print(showPrev ? "[PREV]" : "");
		
		for(int i = beginPage; i <= endPage; i++) {
			System.out.print(i+ " ");
			
		}
		System.out.println(showNext ? "[NEXT]" : " ");
	}
	


	public SearchCondition getSc() {
		return sc;
	}

	public void setSc(SearchCondition sc) {
		this.sc = sc;
	}

	@Override
	public String toString() {
		return "PageHandler [sc=" + sc + ", totalCnt=" + totalCnt + ", navSize=" + navSize + ", totalPage=" + totalPage
				+ ", beginPage=" + beginPage + ", endPage=" + endPage + ", showPrev=" + showPrev + ", showNext="
				+ showNext + "]";
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}


	public int getNavSize() {
		return navSize;
	}

	public void setNavSize(int navSize) {
		this.navSize = navSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}
	
	
	
	
}
