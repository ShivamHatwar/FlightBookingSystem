package com.cg.FlightBookingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="users")
public class Users {

	@Id
	@SequenceGenerator(name ="userseq", sequenceName="userseq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userseq")
	@Column (name="USER_ID")
	private int user_Id;
	
	@Column (name="Name")
	private String name;
	
	@Column (name="Username")
	private String username;
	
	@Column (name="Password")
	private String password;
	
	@Column (name="Age")
	private int age;
	
	@Column (name="Email")
	private String email;
	
	@Column (name="mobileNumber")
	private long mobileNum;

	public Users() {
		
	}
	
	public Users(String name, String username, String password, int age, String email, long mobileNum) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
		this.mobileNum = mobileNum;
	}

	public int getUser_id() {
		return user_Id;
	}

	public void setUser_id(int user_id) {
		this.user_Id = user_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}
	
}
