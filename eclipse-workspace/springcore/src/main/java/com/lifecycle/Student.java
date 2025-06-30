package com.lifecycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student{ //implements InitializingBean,DisposableBean {

private int studentId;
private String studentName;
private String email;
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
 System.out.println("Student Id setter method");
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
	 System.out.println("Student Name setter method");

}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
	 System.out.println("Student email setter method");

}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + "]";
}
}
