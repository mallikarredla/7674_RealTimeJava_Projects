package com.java8.predicate;

import java.util.function.Predicate;

public class A {
public static boolean checkNumber(int num) {
	return num==2020;
	
}
public static void main(String[] args) {
	System.out.println(checkNumber(2021));
	

Predicate<Integer>predicate=(num)->num==2021;
System.out.println(predicate.test(2021));
System.out.println(predicate.test(2020));

Predicate<String>p2=(s)->(s.length()>5);
System.out.println(p2.test("JavaExpress"));
System.out.println(p2.test("Java"));

}
}