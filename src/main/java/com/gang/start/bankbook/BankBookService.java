package com.gang.start.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	

	@Autowired
	private BankBookDAO bankBookDAO;

public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
	
	
	return bankBookDAO.setUpdate(bankBookDTO);
}
	
	
	public int setBankBook( BankBookDTO bankBookDTO) throws Exception{
		
		 return bankBookDAO.setBankBook(bankBookDTO);
	
	}
		
	
	public List<BankBookDTO> getlist()throws Exception{
		
		return bankBookDAO.getlist();
				
				
		
	}
		
	

		public int setChangeSale (BankBookDTO bankBookDTO)throws Exception{
			
			return bankBookDAO.setChangeSale(bankBookDTO);
		}
	

		
		public BankBookDTO getDetail (BankBookDTO bankBookDTO) throws Exception{
			
			return bankBookDAO.getDetail(bankBookDTO);
		}


		public int setDelete(BankBookDTO bankBookDTO) throws Exception {
			// TODO Auto-generated method stub
			return bankBookDAO.setDelete(bankBookDTO);
		}

}
