
package com.gang.start.members;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gang.start.account.BankAccountDTO;
import com.gang.start.account.BankAccountService;



@Controller 
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할, 
//Container에게 이 클래스의 객체를 생성 위임(New ~~~)
public class MemberController {
	
	//annotation
	//@ : 설명 + 실행
	
	@Autowired
	private BankMembersService bankMembersService;
	/*
	@Autowired
	private BankAccountService bankAccountService;
	
	*/
	
	// /member/login
	@RequestMapping(value = "login.gang", method= RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	// /member/login
		@RequestMapping(value = "login.gang", method= RequestMethod.POST)
		public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
			System.out.println("DB에 로그인 실행");
			//"redirect:다시접속할URL주소(절대경로, 상대경로)"
			
			
			bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
			model.addAttribute("member",bankMembersDTO);
			
			//HttpSession session = request.getSession();
			session.setAttribute("member", bankMembersDTO);
			
			
			 if(bankMembersDTO != null) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}
			
			//System.out.println(bankMembersDTO);
			
			return "redirect:../";
		}
		
	

	// /member/join  Get
	@RequestMapping(value = "join.gang",method= RequestMethod.GET)
	public void join() throws Exception {
		System.out.println("회원가입 GET 실행");
		
		//return "member/join";
	}
	
	@RequestMapping(value = "join.gang", method=RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("회원가입 POST 실행");
		
		/*
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName(username);
		bankMembersDTO.setPassword(pw);
		bankMembersDTO.setName(name);
		bankMembersDTO.setEmail(email);
		bankMembersDTO.setPhone(phone);
		*/
		

		//int result = bankMembersService.setJoin(bankMembersDTO);
		
		//System.out.println(result);
		
		System.out.println(photo);
		System.out.println("upload 파일명 : " +photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : "+photo.getName());
		System.out.println("upload 하는 file의 크기 : " + photo.getSize());
		int result = bankMembersService.setJoin(bankMembersDTO,photo,session.getServletContext());
		
		return "member/accept";
	}
	
	@RequestMapping(value = "search.gang", method=RequestMethod.GET) 
	public ModelAndView getSearchByID() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/search");
		
		System.out.println("ID 검색 실행");
		
		return mv;
		
	}
	
	@RequestMapping(value="search.gang",method=RequestMethod.POST)
	public String getSearchByID(String userName, Model model) throws Exception {
		
	
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(userName);
		
		model.addAttribute("list", ar);
		
		return "member/list";
	}
	
	@RequestMapping(value="logout.gang", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
		
	}
	
	@RequestMapping(value="myPage.gang", method=RequestMethod.GET)
	public String myPage(BankMembersDTO bankMembersDTO, HttpSession session, Model model) throws Exception{
		System.out.println("MyPage GET");
		bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		//bankMembersDTO.setUserName(bankMembersDTO.getUserName());
		//Map<String, Object> map = bankMembersService.myPage(bankMembersDTO);
		
		//model.addAttribute("map",map);
		
		bankMembersDTO = bankMembersService.myPage(bankMembersDTO);
		//List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
		//model.addAttribute("list", ar);
		model.addAttribute("dto",bankMembersDTO);
		/*
		bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		//BankAccountDTO bankAccountDTO = (BankAccountDTO) session.getAttribute("account");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
		model.addAttribute("ad", ar);
		//model.addAttribute("ad",bankAccountDTO);
		return "member/myPage";
		*/
		return "member/myPage";
	}
	
	@RequestMapping(value ="accept.gang", method = RequestMethod.GET)
	public String accept() throws Exception {
		
		return "member/accept";
		
	}
	
	@RequestMapping(value="accept.gang", method=RequestMethod.POST)
	public String accept(ModelAndView mv) throws Exception {
		
		return "member/login";
	
	}
}
