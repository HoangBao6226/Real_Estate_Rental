package com.javaweb.service.implement;

import com.javaweb.dao.custom.AccomRepoCustom;
import com.javaweb.dao.itface.AccomRepository;
import com.javaweb.dao.itface.AccomTypeRepository;
import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.AccomTypeEntity;
import com.javaweb.service.converter.AccomConverter;
import com.javaweb.service.converter.AccomTypeConverter;
import com.javaweb.service.itface.AccomService;
import com.javaweb.service.itface.AccomTypeService;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.AccomTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class AccomTypeSerImplement implements AccomTypeService {

	@Autowired
	private AccomTypeRepository accomTypeRepo;

	@Autowired
	private AccomTypeConverter accomTypeConverter;

	@Override
	public List<AccomTypeDTO> findAllAccomType() {

		List<AccomTypeEntity> listAccomTypeEntity = accomTypeRepo.findAll();
		List<AccomTypeDTO> listAccomTypeDTO = new ArrayList<AccomTypeDTO>();

		for(AccomTypeEntity item : listAccomTypeEntity) {
			AccomTypeDTO ac = accomTypeConverter.toAccomTypeDTO(item);
			listAccomTypeDTO.add(ac);
		}
		return listAccomTypeDTO;
	}

}