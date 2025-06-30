package com.component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	@Value("dell")
	
	
	private String companyName;
	@Value("Vostro")
	private String mode;
	@Value("50000")
	private int price;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getModel() {
		return mode;
	}
	public void setModel(String model) {
		this.mode = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [companyName=" + companyName + ", mode=" + mode + ", price=" + price + "]";
	}
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
