package com.gang.start.bankbook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gang.start.bankbook.BankBookCommentDAO.";
	
	public int setReply(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", bankBookCommentDTO);
	}
	

}
