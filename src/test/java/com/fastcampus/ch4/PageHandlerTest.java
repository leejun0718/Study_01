package com.fastcampus.ch4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fastcampus.ch4.domain.PageHandler;

public class PageHandlerTest {

	@Test
	public void test() {
		PageHandler ph = new PageHandler(250,1);
		ph.print();
		System.out.println("dddd  " +ph.getBeginPage());
		System.out.println("ddd   " + ph.getEndPage());
		
		assertTrue(ph.getBeginPage() ==1);
		assertTrue(ph.getEndPage() ==10);
	}
	
	@Test
	public void test2() {
		PageHandler ph = new PageHandler(250,11);
		ph.print();
		System.out.println("dddd  " +ph.getBeginPage());
		System.out.println("ddd   " + ph.getEndPage());
		
		assertTrue(ph.getBeginPage() ==11);
		assertTrue(ph.getEndPage() ==20);
	}
	
	@Test
	public void test3() {
		PageHandler ph = new PageHandler(255,25);
		ph.print();
		System.out.println("dddd  " +ph.getBeginPage());
		System.out.println("ddd   " + ph.getEndPage());
		
		assertTrue(ph.getBeginPage() ==21);
		assertTrue(ph.getEndPage() ==26);
	}
}
