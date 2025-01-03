package com.javaweb.service.model;

import com.javaweb.entity.LessorEntity;

public class AccomDTO {

	private int accommodationID;
	private String accommodationName;
	private String address;
	private String direction;
	private float size;
	private int numberOfRooms;
	private String image;
	private String map;
	private LessorEntity lessorID;
	private int salesID;
	private String amenity;
	private String[] rentType;
	private String[] price;
	private String[] deposit;
	private String accomType;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public LessorEntity getLessorID() {
		return lessorID;
	}

	public void setLessorID(LessorEntity lessorID) {
		this.lessorID = lessorID;
	}

	public int getSalesID() {
		return salesID;
	}

	public void setSalesID(int salesID) {
		this.salesID = salesID;
	}

	public String[] getRentType() {
		return rentType;
	}

	public void setRentType(String[] rentType) {
		this.rentType = rentType;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String[] getPrice() {
		return price;
	}

	public void setPrice(String[] price) {
		this.price = price;
	}

	public String[] getDeposit() {
		return deposit;
	}

	public void setDeposit(String[] deposit) {
		this.deposit = deposit;
	}

	public String getAccomType() {
		return accomType;
	}

	public void setAccomType(String accomType) {
		this.accomType = accomType;
	}

}