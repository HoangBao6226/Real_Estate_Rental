package com.javaweb.entity.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;



@Embeddable
public class DetailAmenityID implements Serializable {
	
	private int accommodationID;
	
	private int amenityID;

	public int getAccommodationID() {
		return accommodationID;
	}

	public void setAccommodationID(int accommodationID) {
		this.accommodationID = accommodationID;
	}

	public int getAmenityID() {
		return amenityID;
	}

	public void setAmenityID(int amenityID) {
		this.amenityID = amenityID;
	}

	public DetailAmenityID(int accommodationID, int amenityID) {
		super();
		this.accommodationID = accommodationID;
		this.amenityID = amenityID;
	}

	public DetailAmenityID() {
		super();
	}
	
	
}
