package com.javaweb.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.repository.itface.DetailAmenityRepository;
import com.javaweb.repository.itface.DetailRTRepository;
import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailAmenityEntity;
import com.javaweb.entity.DetailRentTypeEntity;
import com.javaweb.service.model.AccomDTO;



@Component
public class AccomConverter {

//	public accomDTO toAccomDTO (accomEntity item) {
//		
//		accomDTO ac = new accomDTO();
//		ac.setAccommodationName(item.getAccommodationName());
//		ac.setAddress(item.getStreet() + ", " + item.getWard() + ", " + item.getDistrict() + ", " + item.getCity() + ", " + item.getProvince());
//		ac.setDirection(item.getDirection());
//		ac.setSize(item.getSize());
//		ac.setNumberOfRooms(item.getNumberOfRooms());
//		ac.setDescription(item.getDescription());
//		
//		return ac;
//	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DetailAmenityRepository deAmenityRepo;
	
	@Autowired
	private DetailRTRepository deRTRepo;
	
	public AccomDTO toAccomDTO (AccomEntity item) {
		
		AccomDTO ac = modelMapper.map(item, AccomDTO.class);

		ac.setAccommodationName(item.getAccommodationName());
		ac.setAddress(item.getStreet() + ", " + item.getWard() + ", " + item.getDistrict() + ", " + item.getCity());
		
		List<DetailAmenityEntity> am = deAmenityRepo.findAllByaccommodationID(item);
		String amenityName = am.stream().map(it -> "" + it.getAmenityID().getAmenityName()).collect(Collectors.joining(", "));
		ac.setAmenity(amenityName);
		
		List<DetailRentTypeEntity> deRT = deRTRepo.findAllByaccommodationID(item);
		String rentType = deRT.stream().map(it -> it.getRentTypeID().getRentTypeName()).collect(Collectors.joining(", "));
		String[] rt = rentType.split(",");
		ac.setRentType(rt);
		String detailRentType = deRT.stream().map(it -> "" + it.getPrice()).collect(Collectors.joining(", "));
		String[] price = detailRentType.split(",");
		ac.setPrice(price);
		
		return ac;
	}
	
}