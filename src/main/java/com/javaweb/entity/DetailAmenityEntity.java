package com.javaweb.entity;

import jakarta.persistence.*;

import com.javaweb.entity.id.DetailAmenityID;

@Entity
@Table(name = "detailamenity")
public class DetailAmenityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailAmenityID;

    @ManyToOne
    @JoinColumn(name = "accommodationID")
	private AccomEntity accommodationID;

    @ManyToOne
    @JoinColumn(name = "amenityID")
    private AmenityEntity amenityID;


    //////////////////////////////////////////////////////////////////////////////////

	public int getDetailAmenityID() {
		return detailAmenityID;
	}

	public void setDetailAmenityID(int detailAmenityID) {
		this.detailAmenityID = detailAmenityID;
	}

	public AccomEntity getAccommodationID() {
		return accommodationID;
	}

	public void setAccommodationID(AccomEntity accommodationID) {
		this.accommodationID = accommodationID;
	}

	public AmenityEntity getAmenityID() {
		return amenityID;
	}

	public void setAmenityID(AmenityEntity amenityID) {
		this.amenityID = amenityID;
	}
}
