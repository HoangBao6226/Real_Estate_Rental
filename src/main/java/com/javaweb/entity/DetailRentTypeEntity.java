package com.javaweb.entity;

import jakarta.persistence.*;

import com.javaweb.entity.id.DetailRentTypeID;

@Entity
@Table(name = "detailrenttype")
@IdClass(DetailRentTypeID.class)
public class DetailRentTypeEntity {

	@Id
    @ManyToOne
    @JoinColumn(name = "accommodationID")
    private AccomEntity accommodationID;
    
	@Id
    @ManyToOne
    @JoinColumn(name = "rentTypeID")
    private RentTypeEntity rentTypeID;

	@Column(name = "price")
    private int price;
	
	@Column(name = "deposit")
    private int deposit;
	
    //////////////////////////////////////////////////////////////////////////////////




	public int getPrice() {
		return price;
	}

	public AccomEntity getAccommodationID() {
		return accommodationID;
	}

	public void setAccommodationID(AccomEntity accommodationID) {
		this.accommodationID = accommodationID;
	}

	public RentTypeEntity getRentTypeID() {
		return rentTypeID;
	}

	public void setRentTypeID(RentTypeEntity rentTypeID) {
		this.rentTypeID = rentTypeID;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
}
