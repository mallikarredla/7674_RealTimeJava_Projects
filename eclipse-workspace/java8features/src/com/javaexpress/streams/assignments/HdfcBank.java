package com.javaexpress.streams.assignments;

public class HdfcBank {
	String customerName;
 int accNo;
 int balance;
 public HdfcBank(String customerName, int accNo,int balance) {
	 super();
	 this.accNo=accNo;
	 this.balance=balance;
	 this.customerName=customerName;
	 
 }
@Override
public String toString() {
	return "HdfcBank [customerName=" + customerName + ", accNo=" + accNo + ", balance=" + balance + "]";
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public int getAccNo() {
	return accNo;
}
public void setAccNo(int accNo) {
	this.accNo = accNo;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
 

}
