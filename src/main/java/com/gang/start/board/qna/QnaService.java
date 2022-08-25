package com.gang.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.impl.BoardService;
import com.gang.start.board.notice.NoticeDAO;
import com.gang.start.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO QnaDAO;
	
	public int setReply(BoardDTO boardDTO) throws Exception{
		return 0;
	}
	
	//글목록
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		Long totalCount = QnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		return QnaDAO.getList(pager);
	}
		
	//글상세보기
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return QnaDAO.getDetail(boardDTO);
	}
		
	//글쓰기
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception{
		System.out.println();
		
		return QnaDAO.setAdd(boardDTO);
	}
		
	//글수정
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return QnaDAO.setUpdate(boardDTO);
	}
		
	//글삭제
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return QnaDAO.setDelete(boardDTO);
	}

}
