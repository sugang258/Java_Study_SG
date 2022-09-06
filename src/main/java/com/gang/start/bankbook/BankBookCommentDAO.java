package com.gang.start.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gang.start.util.CommentPager;
import com.gang.start.util.Pager;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gang.start.bankbook.BankBookCommentDAO.";
	
	public int setReply(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getReply(CommentPager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getReply", pager);
	}
	

}
