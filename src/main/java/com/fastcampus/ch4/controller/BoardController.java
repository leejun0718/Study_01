package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.*;
import com.fastcampus.ch4.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import javax.servlet.http.*;

import java.net.URLEncoder;
import java.time.*;
import java.util.*;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;


	@PostMapping("/modify")
	public String modify(BoardDto boardDto,Model m, HttpSession session,RedirectAttributes rattr) {
		String writer = (String) session.getAttribute("id");
		boardDto.setWriter(writer);
		try {
			int rowCnt = boardService.modify(boardDto);
			
			if(rowCnt != 1) {
				throw new Exception("MODIFY FAIL");
			}
			rattr.addFlashAttribute("msg","MOD_OK");
			return "redirect:/board/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("boardDto",boardDto);
			rattr.addFlashAttribute("msg","MOD_ERR");
			return "board";
		}
		
	}
	
	@PostMapping("/write")
	public String write(BoardDto boardDto,Model m, HttpSession session,RedirectAttributes rattr) {
		String writer = (String) session.getAttribute("id");
		boardDto.setWriter(writer);
		try {
			int rowCnt = boardService.write(boardDto);
			
			if(rowCnt != 1) {
				throw new Exception("write fail");
			}
			rattr.addFlashAttribute("msg","WRT_OK");
			return "redirect:/board/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("boardDto",boardDto);
			rattr.addFlashAttribute("msg","WRT_ERR");
			return "board";
		}
		
	}
	
	@GetMapping("/write")
	public String write(Model m) {
		m.addAttribute("mode","new");
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
	
	
	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
		String writer = (String)session.getAttribute("id");
		
		try {
			m.addAttribute("page",page);
			m.addAttribute("pageSize",pageSize);
			int rowCnt = boardService.remove(bno, writer);
			
			if(rowCnt == 1) {
				rattr.addFlashAttribute("msg","DEL_OK");
				return "redirect:/board/list";
			}else {
				throw new Exception("board remove error");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg","DEL_ERR");
		}
		
		return "redirect:/board/list";
	}
}