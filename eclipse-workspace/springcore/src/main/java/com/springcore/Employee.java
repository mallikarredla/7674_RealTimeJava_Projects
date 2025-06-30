package com.springcore;

public class Employee {
	
	private  String employeeId;
	private  String employeeName;
	private  String employeeAge;
	private  int salary;
	
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeId, String employeeName, String employeeAge, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.salary = salary;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", salary=" + salary + "]";
	}
	

	

}
