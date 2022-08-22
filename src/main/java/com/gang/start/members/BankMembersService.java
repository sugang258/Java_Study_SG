package com.gang.start.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.start.account.BankAccountDAO;
import com.gang.start.account.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	/*
	@Autowired
	private BankAccountDAO bankAccountDAO;
	*/
	

	//bankMembers 회원가입
		public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
			
			return bankMembersDAO.setJoin(bankMembersDTO);
		}
		
		//검색어를 입력해서 id를 찾기
		public List<BankMembersDTO> getSearchByID(String search) throws Exception{
			
			return bankMembersDAO.getSearchByID(search);
			
		}
			
		public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
			
			return bankMembersDAO.getLogin(bankMembersDTO);
		}
		/*
		public Map<String, Object> myPage(BankMembersDTO bankMembersDTO) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
			bankMembersDTO = bankMembersDAO.myPage(bankMembersDTO);
			map.put("list", ar);
			map.put("dto", bankMembersDTO);
			
			return map;
			
			
		}
		*/
		
		public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception {
			System.out.println("33333");
			return bankMembersDAO.myPage(bankMembersDTO);
		}
}
