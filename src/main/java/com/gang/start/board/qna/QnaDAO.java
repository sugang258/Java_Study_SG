package com.gang.start.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gang.start.board.impl.BoardDAO;
import com.gang.start.board.impl.BoardDTO;
import com.gang.start.util.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gang.start.board.qna.QnaDAO.";
	
	
	
	public List<BoardDTO> getList(Pager pager) throws Exception {

		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}

	public int setUpdate(BoardDTO boardDTO) throws Exception {

		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception {

		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	public int setReply(BoardDTO boardDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setReply", boardDTO);
	}
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount",pager);
	}
	
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setReplyAdd",qnaDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setStepUpdate",qnaDTO);
	}
	
	
	

}
