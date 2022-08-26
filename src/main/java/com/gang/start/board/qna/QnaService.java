package com.gang.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gang.start.board.impl.BoardDTO;
import com.gang.start.board.impl.BoardService;
import com.gang.start.board.notice.NoticeDAO;
import com.gang.start.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO QnaDAO;
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		
		BoardDTO boardDTO = QnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO) boardDTO;
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		QnaDAO.setStepUpdate(parent);
		int result = QnaDAO.setReplyAdd(qnaDTO);
		
		return result;
		
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
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files) throws Exception{
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
