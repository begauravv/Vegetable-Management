package com.hexaware.veggies.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "manager")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private Long managerId;
	
	@Column(name = "first_name",nullable = false)
	private String firstName;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "username",nullable = false)
	private String userName;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	  @JoinColumn(name="vegetable_fkid" ,referencedColumnName = "manager_id")
	  List<Vegetable> vegetable=new ArrayList<>();

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String firstName, String lastName, String email, String userName, String password,
			List<Vegetable> vegetable) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.vegetable = vegetable;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Vegetable> getVegetable() {
		return vegetable;
	}

	public void setVegetable(List<Vegetable> vegetable) {
		this.vegetable = vegetable;
	}

	public Manager(Long managerId, String firstName, String lastName, String email, String userName, String password,
			List<Vegetable> vegetable) {
		super();
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.vegetable = vegetable;
	}

	

}
