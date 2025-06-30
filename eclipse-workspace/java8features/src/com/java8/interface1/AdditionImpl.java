package com.java8.interface1;
  interface IAddition{
	void add(int a, int b);
  }
public class AdditionImpl {
	public static void main(String[] args) {
		IAddition obj=(int a, int b)->{System.out.println(a+b);
		
		};
		obj.add(20, 20);
	}
	

}
