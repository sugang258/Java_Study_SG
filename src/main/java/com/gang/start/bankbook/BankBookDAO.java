package com.gang.start.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
@Repository


public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.gang.start.bankbook.BankBookDAO.";
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
	
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
		

	}
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
		
		return sqlSession.insert(NAMESPACE+"setBankBook",bankBookDTO);
	}
	
	
	
	public List<BankBookDTO> getList() throws Exception {
		
			
		return sqlSession.selectList(NAMESPACE+"getlist"); 
		
		
	}


	public BankBookDTO getDetail(BankBookDTO BankBookDTO) throws Exception{
			
			
			return sqlSession.selectOne(NAMESPACE+"getDetail", BankBookDTO);
	
				
			}
	
	public int setChangeSale(BankBookDTO BankBookDTO) throws Exception {
		
				
		return sqlSession.update(NAMESPACE+"setChangeSale", BankBookDTO);
	}

	
	public int setDelete (BankBookDTO bankBookDTO) throws Exception {
		
	return sqlSession.delete(NAMESPACE+"setDelete",bankBookDTO);
			
	}


}
