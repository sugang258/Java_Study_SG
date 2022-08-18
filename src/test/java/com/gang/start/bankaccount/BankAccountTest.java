package com.gang.start.bankaccount;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;

public class BankAccountTest extends MyAbstractTest {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	private BankAccountDTO bankAccountDTO;

	@Test
	public void add() throws Exception {
		long a_num = 1;
		String name = "SSSUUU";
		long b_num = 1;
		//String date = "2022/08/22";
		//Date date = 2022-08-12; 
		BankAccountDTO dto = new BankAccountDTO();
		dto.setAccountNum(a_num);
		dto.setUserName(name);
		dto.setBookNum(b_num);
		//dto.setAccountDate(date);
		
		
		int result = bankAccountDAO.add(dto);
		
		assertEquals(1, result);
	}
	

}
