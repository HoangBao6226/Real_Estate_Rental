package com.javaweb.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.dao.custom.AccomRepoCustom;
import com.javaweb.dao.itface.AccomRepository;
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
	
//	@Override
	public List<AccomDTO> findAll(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName) {
		
		List<AccomEntity> listAccomEntity = accomRepoCustom.searchAccom(params, amenityName, rentTypeName);
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();
		
		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
//		return null;
	}

}