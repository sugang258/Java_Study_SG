package com.gang.start.bankbookMembers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;

public class bankbookMemberDAOTest extends MyAbstractTest {

	@Autowired
	private BankbookMembersDAO bankbookMembersDAO;
	
	@Test
	public void setJoinTest() throws Exception{
		int result = bankbookMembersDAO.setJoin("sugang");
		throw new Exception();
		//assertEquals(1, result);
	}
	
	@Test
	public void getLoginTest() throws Exception {
		Object obj = bankbookMembersDAO.getLogin("sugang");
		assertNotNull(obj);
	}
	
	@Test
	public void getSearch() throws Exception {
		List<Object> ar = bankbookMembersDAO.getSearch("sugang");
		
		assertNotEquals(0, ar.size());
	}
	
	

}
