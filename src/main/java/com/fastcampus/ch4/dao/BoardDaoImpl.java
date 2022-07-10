package com.fastcampus.ch4.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.ch4.domain.BoardDto;


@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession session;
	String namespace = "com.fastcampus.ch4.dao.BoardMapper.";
	
	
   public BoardDto select(int bno)throws Exception{
	   
	return session.selectOne(namespace+"select",bno);
	
   }
   
   public int update(BoardDto boardDto) throws Exception{
	   
	   return session.update(namespace+"update",boardDto);
   }
	

}
