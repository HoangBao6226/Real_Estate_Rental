package com.javaweb.entity;

import jakarta.persistence.*;

import com.javaweb.entity.id.DetailRentTypeID;

@Entity
@Table(name = "detailrenttype")
public class DetailRentTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailRentTypeID;

    @ManyToOne
    @JoinColumn(name = "accommodationID")
    private AccomEntity accommodationID;

    @ManyToOne
    @JoinColumn(name = "rentTypeID")
    private RentTypeEntity rentTypeID;

	@Column(name = "price")
    private int price;
	
	@Column(name = "deposit")
    private int deposit;
	
    //////////////////////////////////////////////////////////////////////////////////

	public int getDetailRentTypeID() {
		return detailRentTypeID;
	}

	public void setDetailRentTypeID(int detailRentTypeID) {
		this.detailRentTypeID = detailRentTypeID;
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

	public int getPrice() {
		return price;
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
