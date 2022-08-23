package com.gang.start.bankbook;

import java.util.List;

import com.gang.start.account.BankAccountDTO;

public class BankBookDTO {
	
	private long bookNum;
	private String bookName;
	private double bookRate;
	private boolean bookSale;
	private List<BankAccountDTO> bankAccountDTOs;
	

	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	public long getBookNum() {
		return bookNum;
	}
	public void setBookNum(long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookRate() {
		return bookRate;
	}
	public void setBookRate(double bookRate) {
		this.bookRate = bookRate;
	}
	public boolean isBookSale() {
		return bookSale;
	}
	public void setBookSale(boolean bookSale) {
		this.bookSale = bookSale;
	}
	
	
	

}
