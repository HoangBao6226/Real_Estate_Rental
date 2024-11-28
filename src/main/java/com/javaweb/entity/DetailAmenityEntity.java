package com.javaweb.entity;

import jakarta.persistence.*;

import com.javaweb.entity.id.DetailAmenityID;

@Entity
@Table(name = "detailamenity")
@IdClass(DetailAmenityID.class)
public class DetailAmenityEntity {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "accommodationID")
	private AccomEntity accommodationID;
    
	@Id
    @ManyToOne
    @JoinColumn(name = "amenityID")
    private AmenityEntity amenityID;



	
    //////////////////////////////////////////////////////////////////////////////////

	
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
