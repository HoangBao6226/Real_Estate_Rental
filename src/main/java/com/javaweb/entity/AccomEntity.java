package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "accommodation")
public class AccomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accommodationID;
	
	@Column(name = "accommodationName")
    private String accommodationName;
	
	@Column(name = "street")
    private String street;
	
	@Column(name = "ward")
    private String ward;
	
	@Column(name = "district")
    private String district;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "province")
    private String province;
	
	@Column(name = "direction")
    private String direction;
	
	@Column(name = "size")
    private float size;
	
	@Column(name = "numberOfRooms")
    private int numberOfRooms;
	
	@Column(name = "description")
    private String description;
	
	@ManyToOne
    @JoinColumn(name = "lessorID")
    private UserEntity lessorID;
   
    @OneToMany(mappedBy = "accommodationID")
    private List<DetailRentTypeEntity> listDetailRT = new ArrayList<DetailRentTypeEntity>();
    
    @OneToMany(mappedBy = "accommodationID")
    private List<DetailAmenityEntity> listDetailAmenity = new ArrayList<DetailAmenityEntity>();

    
    //////////////////////////////////////////////////////////////////////////////////
    
     
	public int getAccommodationID() {
		return accommodationID;
	}

	public void setAccommodationID(int accommodationID) {
		this.accommodationID = accommodationID;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getLessorID() {
		return lessorID;
	}

	public void setLessorID(UserEntity lessorID) {
		this.lessorID = lessorID;
	}

	public List<DetailRentTypeEntity> getListDetailRT() {
		return listDetailRT;
	}

	public void setListDetailRT(List<DetailRentTypeEntity> listDetailRT) {
		this.listDetailRT = listDetailRT;
	}

	public List<DetailAmenityEntity> getListDetailAmenity() {
		return listDetailAmenity;
	}

	public void setListDetailAmenity(List<DetailAmenityEntity> listDetailAmenity) {
		this.listDetailAmenity = listDetailAmenity;
	}



    
}