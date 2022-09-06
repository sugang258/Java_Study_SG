package com.gang.start.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;

public class BankBookCommentTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setAdd() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		
		bankBookCommentDTO.setBookNum(1L);
		bankBookCommentDTO.setWriter("s2");
		bankBookCommentDTO.setContents("S2");
		
		int result = bankBookCommentDAO.setReply(bankBookCommentDTO);
		assertEquals(1,result);
		
	}

}
