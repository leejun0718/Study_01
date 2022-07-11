package com.fastcampus.ch4;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcampus.ch4.dao.BoardDao;
import com.fastcampus.ch4.domain.BoardDto;


@RunWith(SpringJUnit4ClassRunner.class)  //Autowired 사용하려면 해줘야함. SPRING TEST pom.xml에 설정해줘야 가능.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//xml설정파일지정
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
		
		BoardDto boardDto = new BoardDto(1,"변경함","변경함","주노찌", 0, 0, new Date());
		int rowCnt = boardDao.update(boardDto);
		assertTrue(rowCnt==1);
		
		int t1 = 5;
		int t2 = 10;
		
		System.out.println("sssssssssssssssssssssss");
		System.out.println("계산1    " + 5 / 10);
		System.out.println("계산2    " + ((5 / 10 * 10)+1));
		
		
	}
    @Test
    public void increaseViewCntTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);

        Integer bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.increaseViewCnt(bno)==1);

        boardDto = boardDao.select(bno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getView_cnt() == 1);

        assertTrue(boardDao.increaseViewCnt(bno)==1);
        boardDto = boardDao.select(bno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getView_cnt() == 2);
    }
    
    @Test
    public void selectPageTest() throws Exception {
        boardDao.deleteAll();

        for (int i = 1; i <= 10; i++) {
            BoardDto boardDto = new BoardDto(""+i, "no content"+i, "asdf");
            boardDao.insert(boardDto);
        }

        Map map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 3);

        List<BoardDto> list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("10"));
        assertTrue(list.get(1).getTitle().equals("9"));
        assertTrue(list.get(2).getTitle().equals("8"));

        map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 1);

        list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("10"));

        map = new HashMap();
        map.put("offset", 7);
        map.put("pageSize", 3);

        list = boardDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("3"));
        assertTrue(list.get(1).getTitle().equals("2"));
        assertTrue(list.get(2).getTitle().equals("1"));
    }
    
    
//    @Test
//    public void countTest() throws Exception {
//        boardDao.deleteAll();
//        assertTrue(boardDao.count()==0);
//
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==1);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==2);
//    }

//    @Test
//    public void deleteAllTest() throws Exception {
//        boardDao.deleteAll();
//        assertTrue(boardDao.count()==0);
//
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.deleteAll()==1);
//        assertTrue(boardDao.count()==0);
//
//        boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.deleteAll()==2);
//        assertTrue(boardDao.count()==0);
//    }

//    @Test
//    public void deleteTest() throws Exception {
//        boardDao.deleteAll();
//        assertTrue(boardDao.count()==0);
//
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        Integer bno = boardDao.selectAll().get(0).getBno();
//        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
//        assertTrue(boardDao.count()==0);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        bno = boardDao.selectAll().get(0).getBno();
//        assertTrue(boardDao.delete(bno, boardDto.getWriter()+"222")==0);
//        assertTrue(boardDao.count()==1);
//
//        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
//        assertTrue(boardDao.count()==0);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        bno = boardDao.selectAll().get(0).getBno();
//        assertTrue(boardDao.delete(bno+1, boardDto.getWriter())==0);
//        assertTrue(boardDao.count()==1);
//    }

//    @Test
//    public void insertTest() throws Exception {
//        boardDao.deleteAll();
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//
//        boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==2);
//
//        boardDao.deleteAll();
//        boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==1);
//    }

//    @Test
//    public void selectAllTest() throws Exception {
//        boardDao.deleteAll();
//        assertTrue(boardDao.count()==0);
//
//        List<BoardDto> list = boardDao.selectAll();
//        assertTrue(list.size() == 0);
//
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//
//        list = boardDao.selectAll();
//        assertTrue(list.size() == 1);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        list = boardDao.selectAll();
//        assertTrue(list.size() == 2);
//    }


}
