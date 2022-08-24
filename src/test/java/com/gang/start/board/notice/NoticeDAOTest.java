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

	@Test
	public void getListTest() throws Exception{
		
		
		List<BoardDTO> ar = noticeDAO.getList();
		
		assertNotEquals(0, ar.size());
		
	}
	
	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(10L);
		
		boardDTO = noticeDAO.getDetail(boardDTO);
		
		assertNotNull(boardDTO);
	}
	
	@Test
	public void setAddTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(1L);
		boardDTO.setTitle("tt");
		boardDTO.setContents("cc");
		boardDTO.setWriter("ID1");
		boardDTO.setRegDate(null);
		boardDTO.setHit(0L);
		
		int result = noticeDAO.setAdd(boardDTO);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void setUpdate() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(10L);
		
		boardDTO.setTitle("tt");
		boardDTO.setContents("CC");
		
		int result = noticeDAO.setUpdate(boardDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void setDelete() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setNum(22L);
		
		int result = noticeDAO.setDelete(boardDTO);
		
		assertEquals(1, result);
	}

}
