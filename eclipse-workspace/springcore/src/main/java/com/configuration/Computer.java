package com.configuration;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
@Component
public class Computer {
	@Value("ABC")
	private String computerName;
	@Value("Dell")
	private String computerCompany;
	@Value("5000")
	private int price;
	public Computer() {
		super();
	}
	@Override
	public String toString() {
		return "Computer [ComputerName=" + computerName + ", computerCompany=" + computerCompany + ", price=" + price
				+ "]";
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		computerName = computerName;
	}
	public String getComputerCompany() {
		return computerCompany;
	}
	public void setComputerCompany(String computerCompany) {
		this.computerCompany = computerCompany;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
