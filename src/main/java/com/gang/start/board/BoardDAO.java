package com.gang.start.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.gang.start.board.BoardDAO.";
	
	//글 목록보기
	public List<BoardDTO> getList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	
	//글 상세보기 detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
		
	}
	
	//글 쓰기 add
	public int add(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"add", boardDTO);
		
	}
	
	//글 수정 update
	public int update(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}
	
	//글 삭제 delete
	public int delete(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", boardDTO);
	}
	
	
	

}
