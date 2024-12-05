package com.javaweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	public enum Gender {
	    Male, Female;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;
	
	@Column(name = "lastName", nullable = false)
    private String lastName;
	
	@Column(name = "firstName", nullable = false)
    private String firstName;

	@Column(name = "email")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
    private Gender gender;
    
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;

	@OneToMany(mappedBy = "employeeID")
	private List<AccountEntity> listAccount = new ArrayList<AccountEntity>();

	@OneToMany(mappedBy = "salesID")
	private List<ReservationEntity> listReverse = new ArrayList<ReservationEntity>();



	//////////////////////////////////////////////////////////////////////////////////

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AccountEntity> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<AccountEntity> listAccount) {
		this.listAccount = listAccount;
	}

	public List<ReservationEntity> getListReverse() {
		return listReverse;
	}

	public void setListReverse(List<ReservationEntity> listReverse) {
		this.listReverse = listReverse;
	}
}
