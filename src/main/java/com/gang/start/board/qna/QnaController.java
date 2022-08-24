package com.gang.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.notice.NoticeService;

@RequestMapping(value="/qna/*")
@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="list.gang", method=RequestMethod.GET)
	public String getList(Model model) throws Exception {
		
		List<QnaDTO> ar = qnaService.getList();
		model.addAttribute("list", ar);
		
		return "notice/list";
		
	}
	
	@RequestMapping(value="detail.gang", method=RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		qnaDTO = qnaService.getDetail(qnaDTO);
		
		mv.setViewName("qna/detail");
		mv.addObject("dto",qnaDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value="add.gang", method=RequestMethod.GET)
	public String setAdd() throws Exception {
		return "qna/add";
	}
	
	
	@RequestMapping(value="add.gang", method=RequestMethod.POST)
	public ModelAndView setAdd(QnaDTO qnaDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
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
