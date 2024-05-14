package com.ssafit.shopping.model.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private String email;
	private int age;
	private String phoneNumber;
	private int height;
	private int weight;
	private String address;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String password, String name, String email, int age, String phoneNumber, int height,
			int weight, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.height = height;
		this.weight = weight;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", height=" + height + ", weight=" + weight + ", address=" + address
				+ "]";
	}
	
	
	
}
