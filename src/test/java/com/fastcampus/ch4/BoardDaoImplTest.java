package com.fastcampus.ch4;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcampus.ch4.dao.BoardDao;
import com.fastcampus.ch4.domain.BoardDto;


@RunWith(SpringJUnit4ClassRunner.class)  //Autowired ����Ϸ��� �������. SPRING TEST pom.xml�� ��������� ����.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//xml������������
public class BoardDaoImplTest {
	
	@Autowired
	BoardDao boardDao;
	
	@Test
	public void select() throws Exception{
		assertTrue(boardDao !=null);
		System.out.println("boardDao      " + boardDao);
		
		BoardDto boardDto = boardDao.select(1);
		System.out.println("boardDto ok    " + boardDto);
		
		assertTrue(boardDto.getBno().equals(1));
		
	}
	
	
	@Test
	public  void update() throws Exception{
		
		BoardDto boardDto = new BoardDto(1,"������","������","�ֳ���", 0, 0, new Date());
		int rowCnt = boardDao.update(boardDto);
		
		
		
		assertTrue(rowCnt==1);
		
		int t1 = 5;
		int t2 = 10;
		
		System.out.println("sssssssssssssssssssssss");
		System.out.println("���1    " + 5 / 10);
		System.out.println("���2    " + ((5 / 10 * 10)+1));
		
		
	}



}
