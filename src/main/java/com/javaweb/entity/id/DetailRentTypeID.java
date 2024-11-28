package com.javaweb.entity.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;



@Embeddable
public class DetailRentTypeID implements Serializable {

	private int accommodationID;

	private int rentTypeID;

	public int getAccommodationID() {
		return accommodationID;
	}

	public void setAccommodationID(int accommodationID) {
		this.accommodationID = accommodationID;
	}

	public int getRentTypeID() {
		return rentTypeID;
	}

	public void setRentTypeID(int rentTypeID) {
		this.rentTypeID = rentTypeID;
	}

	public DetailRentTypeID() {
		super();
	}

	public DetailRentTypeID(int accommodationID, int rentTypeID) {
		super();
		this.accommodationID = accommodationID;
		this.rentTypeID = rentTypeID;
	}


}
