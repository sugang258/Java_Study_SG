package com.gang.start.account;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gang.start.members.BankMembersDTO;
@Repository
public class BankAccountDAO {

	    @Autowired
	    private SqlSession sqlSession;
		private final String NAMESPACE="com.gang.start.account.BankAccountDAO.";


	    public int add( BankAccountDTO bankAccountDTO) throws Exception{
	
			
			return sqlSession.insert(NAMESPACE+"add", bankAccountDTO);	
	
}
	    
	    public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception {
	    	return sqlSession.selectList(NAMESPACE+"getListByUserName",bankMembersDTO);
	    }
	    
	    
}
