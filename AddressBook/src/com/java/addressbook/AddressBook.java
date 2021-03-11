package com.java.addressbook;

public class AddressBook {
	private String name;
	private String phone;
	private String tel;
	
	public AddressBook(String name, String phone, String tel) {
		super();
		this.name = name;
		this.phone = phone;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
