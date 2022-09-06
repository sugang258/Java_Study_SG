package com.gang.start.bankbook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.bankbook.BankBookDAO;
import com.gang.start.bankbook.BankBookDTO;
import com.gang.start.members.BankMembersDTO;
import com.gang.start.util.CommentPager;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value ="list.gang", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		//ModelAndView mv = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.getList();
		
		model.addAttribute("list", ar);
		
		//request.setAttribute("list", ar);
				
		return "bankbook/list";
		
	}
	
	@RequestMapping(value = "detail.gang", method=RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		
		//request.setAttribute("dto", bankbookDTO);
		
		session.setAttribute("dto",bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		//return "/bankbook/detail";
		return mv;
		
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value ="add.gang", method=RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("상품 등록 실행 GET");
		
		//return "/bankbook/add";
		
		
	}
	
	@RequestMapping(value ="add.gang", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("상품 등록 실행 POST");
		
		
		Calendar ca = Calendar.getInstance();
		long num = ca.getTimeInMillis();
		
		bankBookDTO.setBookNum(num);
		bankBookDTO.setBookSale(true);

		bankBookService.setBankBook(bankBookDTO);
		//System.out.println(result);
		mv.setViewName("redirect:./list.gang");
		//mv.addObject("list",bankBookDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value="update.gang" , method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("업데이트 실행");
		
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO= bankBookService.getDetail(bankBookDTO);
		
		model.addAttribute("dto",bankBookDTO);
	
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		System.out.println("업데이트 POST 실행");
		
		
		int result = bankBookService.setUpdate(bankBookDTO);
		
		System.out.println(result);
		
		mv.setViewName("redirect:./detail.gang?booknum="+bankBookDTO.getBookNum());
		//mv.setViewName("redirect:./list");
		return mv;
	
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("삭제 실행");
		
		int result = bankBookService.setDelete(bankBookDTO);
		
		System.out.println(result);
		
		mv.setViewName("redirect:./list.gang");
		
		return mv;
	}
	
	//-----------------------Comment----------------------------------
//	@PostMapping("setReply")
//	public ModelAndView setReply(BankBookCommentDTO bankBookCommentDTO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		System.out.println("답글 실행");
//	
//		int result = bankBookService.setReply(bankBookCommentDTO);
//		
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		return mv;
//		
//	}
	@PostMapping("setReply")
	@ResponseBody
	public String setReply(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("답글 실행");
		
		int result = bankBookService.setReply(bankBookCommentDTO);
		
		//{}
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
		
	}
	
	//1. JSP에 출력하고 결과물을 응답으로 전송
//	@GetMapping("getReply")
//	public ModelAndView getReply(CommentPager pager) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("답글 리스트 실행");
//		
//		List<BankBookCommentDTO> ar = bankBookService.getReply(pager);
//		
//		System.out.println(ar.size());
//		
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//		
//		return mv;
//	
//	}
	@GetMapping("getReply")
	@ResponseBody
	public List<BankBookCommentDTO> getReply(CommentPager pager) throws Exception {
		System.out.println("답글 리스트 실행");
		
		List<BankBookCommentDTO> ar = bankBookService.getReply(pager);
		
		System.out.println(ar.size());
		
		return ar;
		
	}
}
