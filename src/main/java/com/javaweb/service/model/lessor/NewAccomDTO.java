package com.javaweb.service.model.lessor;

import com.javaweb.entity.DetailRentTypeEntity;

import java.util.List;

public class NewAccomDTO {

    private String accommodationName;
    private String street;
    private String ward;
    private String district;
    private String city;
    private String direction;
    private float size;
    private int numberOfRooms;
    private String type;
//    private List<String> amenityName;
    private List<String> rentTypeName;
    private List<DetailRentTypeEntity> deRTs;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public List<String> getAmenityName() {
//        return amenityName;
//    }
//
//    public void setAmenityName(List<String> amenityName) {
//        this.amenityName = amenityName;
//    }


    public List<String> getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(List<String> rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<DetailRentTypeEntity> getDeRTs() {
        return deRTs;
    }

    public void setDeRTs(List<DetailRentTypeEntity> deRTs) {
        this.deRTs = deRTs;
    }
}
