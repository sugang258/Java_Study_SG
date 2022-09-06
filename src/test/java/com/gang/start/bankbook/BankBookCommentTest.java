package com.gang.start.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;
import com.gang.start.util.CommentPager;

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
	
	@Test
	public void getReply() throws Exception{

		CommentPager pager = new CommentPager();
		pager.setBookNum(1L);
		pager.setPage(1L);
		pager.getRowNum();
	
		
//		pager.setStartRow(1L);
//		pager.setLastRow(10L);
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getReply(pager);
		
		
		assertNotEquals(0, ar.size());
	}

}
