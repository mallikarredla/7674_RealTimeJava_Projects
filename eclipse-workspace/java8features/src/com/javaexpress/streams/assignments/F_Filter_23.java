package com.javaexpress.streams.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class F_Filter_23 {

	
	
	public static void main(String[] args) {
		List<HdfcBank >list=new ArrayList<>();
		list.add(new HdfcBank("ramesh",654,1000));
		list.add(new HdfcBank("suresh",655,1001));
		list.add(new HdfcBank("ganesh",656,1002));
		list.add(new HdfcBank("harish",657,1003));
List<HdfcBank>result=list.stream().filter(bank->bank.balance<1004).collect(Collectors.toList());
System.out.println(result);
		
		
	}
}

