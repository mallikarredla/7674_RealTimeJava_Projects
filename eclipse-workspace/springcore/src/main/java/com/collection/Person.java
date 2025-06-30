package com.collection;
import java.util.*;

public class Person {
	
	private int personId;
	private List<String> hobbies;
	private Set<String> phones;
	private Map<String,String> country;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Set<String> getPhones() {
		return phones;
	}
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	public Map<String, String> getCountry() {
		return country;
	}
	public void setCountry(Map<String, String> country) {
		this.country = country;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", hobbies=" + hobbies + ", phones=" + phones + ", country=" + country
				+ "]";
	}
	
	

}
