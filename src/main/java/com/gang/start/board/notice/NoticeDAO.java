package com.gang.start.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gang.start.board.impl.BoardDAO;
import com.gang.start.board.impl.BoardDTO;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gang.start.board.notice.NoticeDAO.";

	@Override
	public List<BoardDTO> getList() throws Exception {

		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {

		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {

		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

}
