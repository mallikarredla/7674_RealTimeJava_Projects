package com.java8.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class C_BankTest {
	
	public static void main(String[] args) {
		List<Bank>list= new ArrayList<>();
		list.add(new Bank("malli1",635356373));
		list.add(new Bank("malli2",763542527));
		list.add(new Bank("malli3",17277272));
		Function<Bank,String>f=bank->bank.getName()
;
		for(Bank bank:list) {
			if(f.apply(bank)!=null) {
				System.out.println(bank.getName());
			}
		}
		
		
	}

}
