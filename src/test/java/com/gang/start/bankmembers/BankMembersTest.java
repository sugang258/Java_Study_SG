package com.gang.start.bankmembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;
import com.gang.start.members.BankMembersDAO;
import com.gang.start.members.BankMembersDTO;
import com.gang.start.members.BankMembersService;

public class BankMembersTest extends MyAbstractTest {

	@Autowired
	private BankMembersService bankMembersService;
	//private BankMembersDTO bankMembersDTO;
	
	@Test
	public void setJoinTest() throws Exception{
		//BankMembersDTO dto = new BankMembersDTO();
		//dto.setUserName("3334");
		//dto.setPassword("3334");
		//dto.setName("3334");
		//dto.setEmail("3334");
		//dto.setPhone("3334");
		
		//int result = bankMembersService.setJoin(dto);
		//assertEquals(1, result);
	}
	
	@Test
	public void getLoginTest() throws Exception {
		
		BankMembersDTO dto = new BankMembersDTO();
		
		dto.setUserName("3334");
		dto.setPassword("3334");
		dto.setName("3334");
		dto.setEmail("3334");
		dto.setPhone("3334");
		
		
		Object obj = bankMembersService.getLogin(dto);
		assertNotNull(obj);
	}
	
	@Test
	public void getSearch() throws Exception {
		List<BankMembersDTO> ar = bankMembersService.getSearchByID("ID");
		
		assertNotEquals(0, ar.size());
	}

}
