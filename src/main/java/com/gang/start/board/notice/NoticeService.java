package com.gang.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//글목록
	@Override
	public List<BoardDTO> getList(Long page) throws Exception{
		System.out.println(page);
		
		Long startRow = 0L;
		Long lastRow =0L;
		Long perPage =15L; //한페이지에 출력할 목록의 갯수
		
		startRow = (page-1)*perPage;
		lastRow = page*perPage;
		
		System.out.println("StartRow" + startRow);
		System.out.println("lastRow" + lastRow);
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		return noticeDAO.getList(map);
		
		
	}
		
	//글상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getDetail(boardDTO);
	}
		
	//글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setAdd(boardDTO);
	}
		
	//글수정
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
		
	//글삭제
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
	
	

}
