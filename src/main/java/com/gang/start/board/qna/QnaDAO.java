package com.gang.start.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gang.start.board.impl.BoardDAO;
import com.gang.start.board.impl.BoardDTO;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gang.start.board.qna.QnaDAO.";
	
	
	
	public List<QnaDTO> getList() throws Exception {

		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE+"getDetail", qnaDTO);
	}
	
	public int setAdd(QnaDTO qnaDTO) throws Exception {

		return sqlSession.insert(NAMESPACE+"setAdd", qnaDTO);
	}

	public int setUpdate(QnaDTO qnaDTO) throws Exception {

		return sqlSession.update(NAMESPACE+"setUpdate", qnaDTO);
	}
	
	public int setDelete(QnaDTO qnaDTO) throws Exception {

		return sqlSession.delete(NAMESPACE+"setDelete", qnaDTO);
	}
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setReply", qnaDTO);
	}
	
	
	

}
