package com.fastcampus.ch4.domain;

import java.util.Iterator;

public class PageHandler {
	int totalCnt; // �� �Խù� ����
	int pageSize; // �� �������� ũ��
	int navSize = 10; // ������ ������̼��� ũ��
	int totalPage; // ��ü �������� ����
	int page; // ���� ������
	public int beginPage; // ������̼��� ù��° ������
	int endPage; // ������̼��� ������ ������
	boolean showPrev; // ������������ �̵��ϴ� ��ũ�� ������ ������ ����
	boolean showNext; // ������������ �̵��ϴ� ��ũ�� ������ ������ ����

	public PageHandler(int totalCnt , int page) {
		this.totalCnt =totalCnt;
		this.page = page;
		this.pageSize = 10;
		totalPage = (int)Math.ceil(totalCnt / pageSize);
		beginPage = page / navSize * navSize + 1;
		endPage = Math.min(beginPage + navSize-1, totalPage);
		showPrev = beginPage !=1;
		showNext = endPage !=totalCnt;
	}
	
	public PageHandler(int totalCnt, int page, int pageSize) {
		this.totalCnt = totalCnt;
		this.page = page;
		this.pageSize = pageSize;
		totalPage = (int)Math.ceil(totalCnt / pageSize);
		beginPage = page / navSize * navSize + 1;
		endPage = Math.min(beginPage + navSize-1, totalPage);
		showPrev = beginPage !=1;
		showNext = endPage !=totalCnt;
	}
	
	public void print() {
		System.out.println("page = " + page);
		System.out.print(showPrev ? "[PREV]" : "");
		
		for(int i = beginPage; i <= endPage; i++) {
			System.out.print(i+ " ");
			
		}
		System.out.println(showNext ? "[NEXT]" : " ");
	}

	@Override
	public String toString() {
		return "PageHandler [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", navSize=" + navSize + ", totalPage="
				+ totalPage + ", page=" + page + ", beginPage=" + beginPage + ", endPage=" + endPage + ", showPrev="
				+ showPrev + ", showNext=" + showNext + "]";
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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
