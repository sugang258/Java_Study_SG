package com.gang.start.account;

import java.sql.Date;
import java.util.List;

import com.gang.start.bankbook.BankBookDTO;

public class BankAccountDTO {
	
	private Long  accountNum; 
	private String userName;
	private long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;
	
	
	
	
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}
	
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getBookNum() {
		return bookNum;
	}
	public void setBookNum(long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	

}
