package com.javaweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

	public enum Gender {
	    Male, Female;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
	
	@Column(name = "lastName", nullable = false)
    private String lastName;
	
	@Column(name = "firstName", nullable = false)
    private String firstName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
    private Gender gender;
    
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @OneToMany(mappedBy = "lessorID")
    private List<AccomEntity> listAccom = new ArrayList<AccomEntity>();

	@OneToMany(mappedBy = "userID")
	private List<AccountEntity> listAccount = new ArrayList<AccountEntity>();

	@OneToMany(mappedBy = "salesID")
	private List<ReservationEntity> listReverse = new ArrayList<ReservationEntity>();
    //////////////////////////////////////////////////////////////////////////////////


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public List<AccomEntity> getListAccom() {
		return listAccom;
	}

	public void setListAccom(List<AccomEntity> listAccom) {
		this.listAccom = listAccom;
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
