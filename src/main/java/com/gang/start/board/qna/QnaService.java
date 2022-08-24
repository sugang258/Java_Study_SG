package com.gang.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.notice.NoticeDAO;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO QnaDAO;
	
	//글목록
	public List<QnaDTO> getList() throws Exception{
		return QnaDAO.getList();
	}
		
	//글상세보기
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception{
		return QnaDAO.getDetail(qnaDTO);
	}
		
	//글쓰기
	public int setAdd(QnaDTO qnaDTO) throws Exception{
		return QnaDAO.setAdd(qnaDTO);
	}
		
	//글수정
	public int setUpdate(QnaDTO qnaDTO) throws Exception{
		return QnaDAO.setUpdate(qnaDTO);
	}
		
	//글삭제
	public int setDelete(QnaDTO qnaDTO) throws Exception{
		return QnaDAO.setDelete(qnaDTO);
	}

}
