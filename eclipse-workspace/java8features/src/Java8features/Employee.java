package Java8features;

public class Employee {

	Integer salary;
	String employeeName;
	String departmentName;
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Employee(Integer salary, String employeeName, String departmentName) {
		super();
		this.salary = salary;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", employeeName=" + employeeName + ", departmentName=" + departmentName
				+ "]";
	}
	
	
}
