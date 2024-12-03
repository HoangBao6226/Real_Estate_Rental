package com.javaweb.repository.builder;

import java.util.List;

public class AccomFindBuilder {

	private String accommodationName;
	private String street;
	private String ward;
	private String district;
	private String city;
	private String province;
	private String direction;
	private float size;
	private int numberOfRooms;
	private List<String> amenityName;
	private List<String> rentTypeName;
	
	
	private AccomFindBuilder(Builder builder) {
		
	    this.accommodationName = builder.accommodationName;
	    this.street = builder.street;
	    this.ward = builder.ward;
	    this.district = builder.district;
	    this.city = builder.city;
	    this.province = builder.province;
	    this.direction = builder.direction;
	    this.size = builder.size;
	    this.numberOfRooms = builder.numberOfRooms;
	    this.amenityName = builder.amenityName;
	    this.rentTypeName = builder.rentTypeName;
	}
	
	public String getAccommodationName() {
		return accommodationName;
	}
	public String getStreet() {
		return street;
	}
	public String getWard() {
		return ward;
	}
	public String getDistrict() {
		return district;
	}
	public String getCity() {
		return city;
	}
	public String getProvince() {
		return province;
	}
	public String getDirection() {
		return direction;
	}
	public float getSize() {
		return size;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public List<String> getAmenityName() {
		return amenityName;
	}
	public List<String> getRentTypeName() {
		return rentTypeName;
	}
	
	public static class Builder {
		
		private String accommodationName;
		private String street;
		private String ward;
		private String district;
		private String city;
		private String province;
		private String direction;
		private float size;
		private int numberOfRooms;
		private List<String> amenityName;
		private List<String> rentTypeName;
		
		public Builder setAccommodationName(String accommodationName) {
			this.accommodationName = accommodationName;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		public Builder setProvince(String province) {
			this.province = province;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setSize(float size) {
			this.size = size;
			return this;
		}
		public Builder setNumberOfRooms(int numberOfRooms) {
			this.numberOfRooms = numberOfRooms;
			return this;
		}
		public Builder setAmenityName(List<String> amenityName) {
			this.amenityName = amenityName;
			return this;
		}
		public Builder setRentTypeName(List<String> rentTypeName) {
			this.rentTypeName = rentTypeName;
			return this;
		}
		
		public AccomFindBuilder build() {
			return new AccomFindBuilder(this);
		}
	}
}
