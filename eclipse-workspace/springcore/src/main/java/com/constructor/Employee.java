package com.constructor;

public class Employee {
	private int employeeId;
	private String employeeName;
	private int salary;
	public Employee(int employeeId, String employeeName, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
