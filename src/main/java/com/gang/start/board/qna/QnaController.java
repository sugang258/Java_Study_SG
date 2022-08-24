package com.gang.start.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.notice.NoticeService;
import com.gang.start.members.BankMembersDTO;

@RequestMapping(value="/qna/*")
@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Qna";
	}
	
	@RequestMapping(value="list.gang", method=RequestMethod.GET)
	public ModelAndView getList() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		List<QnaDTO> ar = qnaService.getList();
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		
		return mv;
		
	}
	
	@RequestMapping(value="detail.gang", method=RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		qnaDTO = qnaService.getDetail(qnaDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("dto",qnaDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public String setAdd() throws Exception {
		return "board/add";
	}
	
	
	@RequestMapping(value="add.gang", method=RequestMethod.POST)
	public ModelAndView setAdd(QnaDTO qnaDTO, BankMembersDTO bankMembersDTO, HttpSession session) throws Exception {
		
		bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		ModelAndView mv = new ModelAndView();
		qnaDTO.setWriter(bankMembersDTO.getUserName());
		int result = qnaService.setAdd(qnaDTO);
		
		mv.setViewName("redirect:./list.gang");
		return mv;
		
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.GET)
	public void setUpdate(QnaDTO qnaDTO, Model model) throws Exception {
		
		qnaDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto",qnaDTO);
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView setUpdate(QnaDTO qnaDTO, ModelAndView mv) throws Exception {
		
		int result = qnaService.setUpdate(qnaDTO);
		mv.setViewName("redirect:./detail.gang?num="+qnaDTO.getNum());
		return mv;
		
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView setDelete(QnaDTO qnaDTO,ModelAndView mv) throws Exception {
		
		int result = qnaService.setDelete(qnaDTO);
		mv.setViewName("redirect:./list.gang");
		
		return mv;
		
	}
	
	
	

}
