package com.gang.start.bankbook;

import java.util.ArrayList;


public class BankBookView {
public void view(ArrayList<BankBookDTO> ar) {
		
		for(BankBookDTO bankBookDTO : ar) {
			
			Long num = bankBookDTO.getBookNum();
			String name = bankBookDTO.getBookName();
			double rate = bankBookDTO.getBookRate();
			boolean sale = bankBookDTO.isBookSale();
			
			System.out.println(num);
			System.out.println(name);
			System.out.println(rate);
			System.out.println(sale);
			System.out.println("===============");
		}
}
		
		public void view(BankBookDTO bankBookDTO) {
			
			Long num = bankBookDTO.getBookNum();
			String name = bankBookDTO.getBookName();
			double rate = bankBookDTO.getBookRate();
			boolean sale = bankBookDTO.isBookSale();
			
			System.out.println(num);
			System.out.println(name);
			System.out.println(rate);
			System.out.println(sale);
			System.out.println("===============");

}
}