package com.gang.start.board.qna;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.notice.NoticeService;
import com.gang.start.members.BankMembersDTO;
import com.gang.start.util.Pager;

@RequestMapping(value="/qna/*")
@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("reply.gang")
	public ModelAndView setReply(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@PostMapping("reply.gang")
	public String setReply(QnaDTO qnaDTO, HttpSession session, BankMembersDTO bankMembersDTO) throws Exception {
		bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		qnaDTO.setWriter(bankMembersDTO.getUserName());
		int result = qnaService.setReply(qnaDTO);

		return "redirect:./list.gang";
	}
	
	
	@RequestMapping(value="list.gang", method=RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("Pager", pager);
		mv.setViewName("board/list");
		
		
		return mv;
		
	}
	
	@RequestMapping(value="detail.gang", method=RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("boardDTO",boardDTO);
		
		return mv;
	}
	
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public String setAdd() throws Exception {
		return "board/add";
	}
	
	
	@RequestMapping(value="add.gang", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, BankMembersDTO bankMembersDTO, HttpSession session,MultipartFile [] files, ServletContext servletContext) throws Exception {
		
		bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		ModelAndView mv = new ModelAndView();
		boardDTO.setWriter(bankMembersDTO.getUserName());
		int result = qnaService.setAdd(boardDTO,files,servletContext);
		
		mv.setViewName("redirect:./list.gang");
		return mv;
		
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO",boardDTO);
		
		return "board/update";
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		System.out.println(boardDTO);
		int result = qnaService.setUpdate(boardDTO);
		mv.setViewName("redirect:./detail.gang?num="+boardDTO.getNum());
		return mv;
		
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView setDelete(BoardDTO boardDTO,ModelAndView mv) throws Exception {
		
		int result = qnaService.setDelete(boardDTO);
		mv.setViewName("redirect:./list.gang");
		
		return mv;
		
	}
	
	
	

}
