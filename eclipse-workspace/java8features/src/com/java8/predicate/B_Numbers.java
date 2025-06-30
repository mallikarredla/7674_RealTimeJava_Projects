package com.java8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class B_Numbers {
	public static void main(String[] args) {
		List<Integer>list=new ArrayList<>();
		list.add(19);
		list.add(20);
		list.add(200);
		list.add(100);
		list.add(7);
		list.add(1);

		Predicate<Integer>predicate=num->num>10;
		for(Integer number :list) {
			if(predicate.test(number)) {
				System.out.println(number);
				
			}
		}
	}

}
