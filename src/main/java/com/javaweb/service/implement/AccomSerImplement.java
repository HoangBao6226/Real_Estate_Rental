package com.javaweb.service.implement;

import java.util.*;
import java.util.stream.Collectors;

import com.javaweb.repository.itface.DetailAmenityRepository;
import com.javaweb.repository.itface.DetailRTRepository;
import com.javaweb.entity.DetailAmenityEntity;
import com.javaweb.entity.DetailRentTypeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.repository.custom.AccomRepoCustom;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.entity.AccomEntity;
import com.javaweb.service.converter.AccomConverter;
import com.javaweb.service.itface.AccomService;
import com.javaweb.service.model.AccomDTO;



@Service
public class AccomSerImplement implements AccomService {

	@Autowired
	private AccomRepository accomRepo;
	
	@Autowired
	private AccomRepoCustom accomRepoCustom;
	
	@Autowired
	private AccomConverter accomConverter;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DetailAmenityRepository deAmenityRepo;

	@Autowired
	private DetailRTRepository deRTRepo;

	@Override
	public AccomDTO findAccomById(int id) {

		AccomEntity item = accomRepo.findById(id).get();
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

	@Override
	public List<AccomDTO> findAllAccom() {
		
		List<AccomEntity> listAccomEntity = accomRepo.findAll();
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();
		
		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
	}

	@Override
	public List<AccomDTO> findAllAccomAvailable() {

		List<AccomEntity> listAccomEntity = accomRepoCustom.findAllAccomAvailable();
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();

		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
	}

	@Override
	public List<AccomDTO> findRandomAccomAvailable() {

		List<AccomEntity> listAccomEntity = accomRepoCustom.findRandomAccomAvailable();
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();

		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
	}

	@Override
	public List<AccomDTO> findAll(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName) {

		List<AccomEntity> listAccomEntity = accomRepoCustom.searchAccom(params, amenityName, rentTypeName);
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();

		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
	}

}