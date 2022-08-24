package com.gang.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.board.impl.BoardDTO;

@RequestMapping(value="/notice/*")
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list.gang", method=RequestMethod.GET)
	public String getList(Model model) throws Exception {
		
		List<BoardDTO> ar = noticeService.getList();
		model.addAttribute("list", ar);
		
		return "notice/list";
		
	}
	
	@RequestMapping(value="detail.gang", method=RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		
		mv.setViewName("notice/detail");
		mv.addObject("dto",boardDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public String setAdd() throws Exception {
		return "notice/add";
	}
	
	
	@RequestMapping(value="add.gang", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		
		mv.setViewName("redirect:./list.gang");
		return mv;
		
		
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.GET)
	public void setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("dto",boardDTO);
		
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
