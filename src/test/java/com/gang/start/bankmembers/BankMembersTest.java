package com.gang.start.bankmembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;
import com.gang.start.members.BankMembersDAO;
import com.gang.start.members.BankMembersDTO;

public class BankMembersTest extends MyAbstractTest {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	private BankMembersDTO bankMembersDTO;
	
	@Test
	public void setJoinTest() throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void getLoginTest() throws Exception {
		Object obj = bankMembersDAO.getLogin(bankMembersDTO);
		assertNotNull(obj);
	}
	
	@Test
	public void getSearch() throws Exception {
		List<BankMembersDTO> ar = bankMembersDAO.getSearchByID("ID");
		
		assertNotEquals(0, ar.size());
	}

}
