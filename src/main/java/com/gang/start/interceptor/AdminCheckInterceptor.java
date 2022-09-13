package com.gang.start.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gang.start.members.BankMembersDTO;
import com.gang.start.members.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. 관리자냐 아니냐 판단 admin -> 로그인한 사용자의 roleDTO 안에 있음 ->ROLENAME이 ADMIN인 사람만
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");

		
		boolean check = false;
		
		for(RoleDTO roleDTO : bankMembersDTO.getRoleDTOs()) {
			System.out.println(roleDTO.getRoleNum());
			System.out.println(roleDTO.getRoleName());
			
			if(roleDTO.getRoleName().equals("admin")) {
				check = true;
				break;
			}
		}
		
		//admin이 아닐 때
		if(!check) {
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로
			view.forward(request, response);
		}
		
		
		return check;
	}
}
