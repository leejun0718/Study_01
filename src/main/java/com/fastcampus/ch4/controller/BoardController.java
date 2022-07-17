package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.*;
import com.fastcampus.ch4.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import javax.servlet.http.*;
import java.time.*;
import java.util.*;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/read")
	public String read(Integer bno,Integer page, Integer pageSize, Model m) {
		try {
			BoardDto boardDto = boardService.read(bno);
			//m.addAttribute("boardDto",boardDto); //�Ʒ� ����� ����
			m.addAttribute(boardDto);
			m.addAttribute("page",page);
			m.addAttribute("pageSzie",pageSize);
			System.out.println("���뼱###########################");
			System.out.println("���뼱###########################");
			System.out.println("���뼱###########################");
			System.out.println(pageSize);
			System.out.println(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board";
	} 
	

	@GetMapping("/list")
	public String list(Integer page, Integer pageSize ,Model m, HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();  // �α����� �������� �α��� ȭ������ �̵�
		
		if(page==null) page=1;
		if(pageSize==null)pageSize =10;
		
		try {
			int totalCnt = boardService.getCount();
			PageHandler pageHandler = new PageHandler(totalCnt,page,pageSize);
			
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
			
			List<BoardDto> list = boardService.getPage(map);
			System.out.println("totalcnt : "+totalCnt);
			System.out.println(list.toString());
			m.addAttribute("list",list);
			m.addAttribute("ph",pageHandler);
			m.addAttribute("page",page);
			m.addAttribute("pageSize",pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardList"; // �α����� �� �����̸�, �Խ��� ȭ������ �̵�
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. ������ ��
		HttpSession session = request.getSession();
		// 2. ���ǿ� id�� �ִ��� Ȯ��, ������ true�� ��ȯ
		return session.getAttribute("id")!=null;
	}
}