package com.sem.domain;

import java.sql.Date;

public class Employee {

	private String empId;
	private String isId;
	private String firstName;
	private String lastName;
	private String address;
	private Date birthDate;
	private String gender;
	private String email;
	private Date joiningDate;
	private String empType;
	private String empStatus;
	private String contactNo;
	private int expLevel;

	public Employee(String empId, String isId, String firstName, String lastName, String address, Date birthDate,
			String gender, String email, Date joiningDate, String empType, String empStatus, String contactNo,
			int expLevel) {
		this.empId = empId;
		this.isId = isId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.joiningDate = joiningDate;
		this.empType = empType;
		this.empStatus = empStatus;
		this.contactNo = contactNo;
		this.expLevel = expLevel;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getIsId() {
		return isId;
	}

	public void setIsId(String isId) {
		this.isId = isId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getExpLevel() {
		return expLevel;
	}

	public void setExpLevel(int expLevel) {
		this.expLevel = expLevel;
	}

}