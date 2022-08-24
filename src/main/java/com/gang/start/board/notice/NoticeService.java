package com.gang.start.board.notice;

import java.util.List;

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
	public List<BoardDTO> getList() throws Exception{
		return noticeDAO.getList();
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
