package com.java8.functions;

import java.util.function.Function;

public class A {
	public static void main(String[] args) {
		
		
		Function<String, Integer>f=s->s.length();
		System.out.println(f.apply("javaexpress channel"));
		Function<String,String>f1=s->s.replaceAll(" ","");
		System.out.println(f1.apply("ja va ex pr es s"));
		Function<String,String>f2=s->s.toUpperCase();
		System.out.println(f2.apply("javaexpress"));
		
	}
}
