package com.gang.start.bankbook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		System.out.println("?????? ?????? ?????? GET");
		
		//return "/bankbook/add";
		
		
	}
	
	@RequestMapping(value ="add.gang", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("?????? ?????? ?????? POST");
		
		
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
		System.out.println("???????????? ??????");
		
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO= bankBookService.getDetail(bankBookDTO);
		
		model.addAttribute("dto",bankBookDTO);
	
	}
	
	@RequestMapping(value="update.gang", method=RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		System.out.println("???????????? POST ??????");
		
		
		int result = bankBookService.setUpdate(bankBookDTO);
		
		System.out.println(result);
		
		mv.setViewName("redirect:./detail.gang?booknum="+bankBookDTO.getBookNum());
		//mv.setViewName("redirect:./list");
		return mv;
	
	}
	
	@RequestMapping(value="delete.gang", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("?????? ??????");
		
		int result = bankBookService.setDelete(bankBookDTO);
		
		System.out.println(result);
		
		mv.setViewName("redirect:./list.gang");
		
		return mv;
	}
	
	//-----------------------Comment----------------------------------
//	@PostMapping("setReply")
//	public ModelAndView setReply(BankBookCommentDTO bankBookCommentDTO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		System.out.println("?????? ??????");
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
	public String setReply(BankBookCommentDTO bankBookCommentDTO, Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("?????? ??????");
		
		int result = bankBookService.setReply(bankBookCommentDTO);
		
		model.addAttribute("comment", bankBookCommentDTO);
		
		//{}
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
		
	}
	
	//1. JSP??? ???????????? ???????????? ???????????? ??????
//	@GetMapping("getReply")
//	public ModelAndView getReply(CommentPager pager) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("?????? ????????? ??????");
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
	public Map<String, Object> getReply(CommentPager pager) throws Exception {
		System.out.println("?????? ????????? ??????");
		
		List<BankBookCommentDTO> ar = bankBookService.getReply(pager);
		
		System.out.println(ar.size());
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", pager);
		
		return map;
		
	}
	
	@PostMapping("setCommentDelete")
	@ResponseBody
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		
		
		return result;
		
		//return result;
		
	}
	
	@PostMapping("setCommentUpdate")
	@ResponseBody
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		System.out.println("?????? ??????");
		
		int result = bankBookService.setCommentUpdate(bankBookCommentDTO);
		
		
		return result;
	}
}
