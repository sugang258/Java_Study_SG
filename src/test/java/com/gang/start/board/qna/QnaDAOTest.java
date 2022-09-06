//package com.gang.start.board.qna;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.gang.start.MyAbstractTest;
//import com.gang.start.board.impl.BoardDTO;
//
//public class QnaDAOTest extends MyAbstractTest {
//
//	@Autowired
//	private QnaDAO qnaDAO;
//	
//	@Test
//	public void getListTest() throws Exception{
//		
//		
//		List<QnaDTO> ar = qnaDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//		
//	}
//	
//	@Test
//	public void getDetailTest() throws Exception {
//		QnaDTO qnaDTO = new QnaDTO();
//		qnaDTO.setNum(22L);
//		
//		qnaDTO = qnaDAO.getDetail(qnaDTO);
//		
//		assertNotNull(qnaDTO);
//	}
//	
//	@Test
//	public void setAddTest() throws Exception {
//		
//		QnaDTO qnaDTO = new QnaDTO();
//		
//		
//		qnaDTO.setNum(1L);
//		qnaDTO.setTitle("tt");
//		qnaDTO.setContents("cc");
//		qnaDTO.setWriter("ID1");
//		
//		int result = qnaDAO.setAdd(qnaDTO);
//		
//		assertEquals(1, result);
//		
//	}
//	
//	@Test
//	public void setUpdate() throws Exception {
//		QnaDTO qnaDTO = new QnaDTO();
//		
//		qnaDTO.setNum(23L);
//		
//		qnaDTO.setTitle("t");
//		qnaDTO.setContents("CC");
//		
//		int result = qnaDAO.setUpdate(qnaDTO);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void setDelete() throws Exception {
//		QnaDTO qnaDTO = new QnaDTO();
//		
//		qnaDTO.setNum(22L);
//		
//		int result = qnaDAO.setDelete(qnaDTO);
//		
//		assertEquals(1, result);
//	}
//
//}
