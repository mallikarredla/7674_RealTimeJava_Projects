package com.java8.interface1;

interface B{
	static final String DB_USERName="root";
	public abstract void m1();
	
		
	}
	

public class A implements B {
	public static void main(String[] args) {
		B obj=new A();
		
		

	
}

	@Override
	public void m1() {
System.out.println("m1 method executed");

	}
}
