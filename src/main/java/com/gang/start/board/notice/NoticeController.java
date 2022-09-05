package com.gang.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


import com.gang.start.board.impl.BoardDTO;
import com.gang.start.members.BankMembersDTO;
import com.gang.start.util.Pager;

@RequestMapping(value="/notice/*")
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@RequestMapping(value="list.gang", method=RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
		
		System.out.println("page : " +pager.getPage());
		
		ModelAndView mv = new ModelAndView();
		
		  System.out.println("page : " +pager);
		List<BoardDTO> ar = noticeService.getList(pager);
		System.out.println("ar size-----" + ar.size());
		mv.addObject("list", ar);
		mv.addObject("Pager", pager);
		
		mv.setViewName("board/list");
		
		return mv;
		
	}
	
	@RequestMapping(value="detail.gang", method=RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		
		mv.setViewName("board/detail");
		
		mv.addObject("boardDTO",boardDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public String setAdd() throws Exception {
		return "board/add";
	}
	
	
	@RequestMapping(value="add.gang", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, BankMembersDTO bankMembersDTO, HttpSession session, MultipartFile [] files) throws Exception {
		
		bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		ModelAndView mv = new ModelAndView();
		System.out.println(boardDTO.getContents());
		boardDTO.setWriter(bankMembersDTO.getUserName());
		int result = noticeService.setAdd(boardDTO,files, session.getServletContext());
		
		String message = "upload 실패";

		if(result > 0) {
			message = "upload 성공";
		}
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", "list.gang");
		mv.setViewName("common/result");
		return mv;
		
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO",boardDTO);
		
		return "board/update";
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		int result = noticeService.setUpdate(boardDTO);
		mv.setViewName("redirect:./detail.gang?num="+boardDTO.getNum());
		return mv;
		
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView setDelete(BoardDTO boardDTO,ModelAndView mv) throws Exception {
		
		int result = noticeService.setDelete(boardDTO);
		mv.setViewName("redirect:./list.gang");
		
		return mv;
		
	}
	
	

}
