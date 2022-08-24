package com.gang.start.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gang.start.MyAbstractTest;
import com.gang.start.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest  {
	
	@Autowired
	private NoticeDAO noticeDAO;

	
	//@Test
	public void getListTest() throws Exception{
		
		
		List<BoardDTO> ar = noticeDAO.getList();
		
		assertNotEquals(0, ar.size());
		
	}
	
	//@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(10L);
		
		boardDTO = noticeDAO.getDetail(boardDTO);
		
		assertNotNull(boardDTO);
	}
	
	@Test
	public void setAddTest() throws Exception {
		/*
		for(int i=0;i<100;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("TITLE"+i);
			noticeDTO.setContents("contents" + i);
			noticeDTO.setWriter("writer" +i);
			
			
			int result = noticeDAO.setAdd(noticeDTO);
			   if(i%10 ==0) { 
		            Thread.sleep(500);
		                
		       }
		}
		/*
		 */
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("TITLE");
		noticeDTO.setContents("contents");
		noticeDTO.setWriter("writer");
	}
	
	//@Test
	public void setUpdate() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(10L);
		
		boardDTO.setTitle("tt");
		boardDTO.setContents("CC");
		
		int result = noticeDAO.setUpdate(boardDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setDelete() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(22L);
		
		int result = noticeDAO.setDelete(boardDTO);
		
		assertEquals(1, result);
	}
	
	
	@Test
	public void getCount() throws Exception {
		long result = noticeDAO.getCount();
		assertEquals(113L,result);
		System.out.println(result);
		
	}
}
