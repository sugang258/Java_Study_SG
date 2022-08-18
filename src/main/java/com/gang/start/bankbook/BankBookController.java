package com.gang.start.bankbook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value= "/bankbook/*")
public class BankBookController {

	@Autowired
	private  BankBookService bankBookService;
	
	
	

 	@RequestMapping(value ="list.gang", method = RequestMethod.GET)
	public void  list(Model model) throws Exception {
				
		System.out.println(" list 실행 ");
		

		List<BankBookDTO> ar = bankBookService.getList();
	
		model.addAttribute("list",ar);

		
	}
	
 	@RequestMapping(value ="detail.gang", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {	
 		
		ModelAndView mv =new ModelAndView();
		
	
	bankBookDTO= bankBookService.getDetail(bankBookDTO);
	
	mv.setViewName("bankbook/detail");
	mv.addObject("dto",bankBookDTO);
	return mv;			
	}

	
	
	@RequestMapping(value ="add.gang", method = RequestMethod.GET)
	public void add() throws Exception {
		
	System.out.println("add 실행");
	
	}

	@RequestMapping(value ="add.gang", method = RequestMethod.POST)
	//public String DBinsert(BookDTO bookDTO) throws Exception {
	public ModelAndView DBinsert(BankBookDTO bankBookDTO) throws Exception {
		
	System.out.println("add 실행");

	 ModelAndView mv =new ModelAndView();

	Calendar ca = Calendar.getInstance();
	long num = ca.getTimeInMillis();
	

	int result = bankBookService.setBankBook(bankBookDTO);
	if(result == 1) {
		
		System.out.println( "계좌 추가 실행");
	}
	
	
	mv.setViewName("redirect:./list.gang");
	
	
	return mv;
	

	
	}

	@RequestMapping(value ="update.gang", method = RequestMethod.GET) // 벨류가 뱅크북에 업데이트가 왔을때 메서드는 get이 왔을때 보냄
	public void update(BankBookDTO bankBookDTO, Model model ) throws Exception {
		//파마리터 처리방법 request(내장객체)선언 , dto선언, 보내고 싶은 객체 선언
		System.out.println("update 실행");
		

		 bankBookDTO= bankBookService.getDetail(bankBookDTO);
		 model.addAttribute("dto", bankBookDTO);
		
		
		
	}

	
	@RequestMapping (value ="update.gang", method =RequestMethod.POST)
	public ModelAndView update (BankBookDTO bankBookDTO) throws Exception{
	
		System.out.println("update1 실행");
		

		ModelAndView mv =new ModelAndView(); //view 경로를 가지고 있음
		
		int result = bankBookService.setUpdate(bankBookDTO);
		System.out.println( result== 1);
		if(result>0) {
			System.out.println("성공");
			mv.setViewName("redirect:./detail.gang?booknum="+bankBookDTO.getBookNum());
		}
		return mv;
		
		
	
		
		
	}
	

	@RequestMapping (value="delete.gang", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("delete");

		ModelAndView mv = new ModelAndView(); 
		int result = bankBookService.setDelete(bankBookDTO);
		System.out.println(result);
		if(result>0) {
			System.out.println("성공");
			mv.setViewName("redirect:./list.gang");
					}
		return mv;
		
	}
	
}
