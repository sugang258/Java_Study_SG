package com.gang.start.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;

public class BankBookTest extends MyAbstractTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void setBankBook() throws Exception{
		BankBookDTO dto = new BankBookDTO();
		
		 dto.setBooknum(1);
		 dto.setBookname("ss");
		 dto.setBookrate(2.22);
		 dto.setBooksale(true);
		
		int result = bankBookDAO.setBankBook(dto);
		assertEquals(1, result);
	}
	
	@Test
	public void getList() throws Exception{
		
		BankBookDTO dto = new BankBookDTO();
		
		dto.setBooknum(1);
		dto.setBookname("TUNGTUNG");
		dto.setBookrate(5.32);
		dto.setBooksale(true);
		
		List<BankBookDTO> ar = bankBookDAO.getList();
		assertNotEquals(0, ar);
		
	}
	
	@Test
	public void setChangeSale() throws Exception {
		int result = bankBookDAO.setChangeSale(bankBookDTO);
		assertEquals(1, result);
		
	}
	
	@Test
	public void getDetail() throws Exception {
		Object obj = bankBookDAO.getDetail(bankBookDTO);
		assertNotNull(obj);
	}
	
	@Test
	public void setUpdate() throws Exception {
		int result = bankBookDAO.setUpdate(bankBookDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setDelete() throws Exception {
		int result = bankBookDAO.setDelete(bankBookDTO);
		assertEquals(1, result);
	}

}
