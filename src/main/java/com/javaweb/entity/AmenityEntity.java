package com.javaweb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "amenity")
public class AmenityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amenityID; 
	
	@Column(name = "amenityName", unique = true)
    private String amenityName;
	
	@Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "amenityID")
    private List<DetailAmenityEntity> listDetailAmenity = new ArrayList<DetailAmenityEntity>();
    
    
    //////////////////////////////////////////////////////////////////////////////////


	public int getAmenityID() {
		return amenityID;
	}

	public void setAmenityID(int amenityID) {
		this.amenityID = amenityID;
	}

	public String getAmenityName() {
		return amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DetailAmenityEntity> getListDetailAmenity() {
		return listDetailAmenity;
	}

	public void setListDetailAmenity(List<DetailAmenityEntity> listDetailAmenity) {
		this.listDetailAmenity = listDetailAmenity;
	}
    
    
}
