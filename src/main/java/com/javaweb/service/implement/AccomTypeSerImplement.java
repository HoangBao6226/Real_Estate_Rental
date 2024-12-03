package com.javaweb.service.implement;

import com.javaweb.repository.itface.AccomTypeRepository;
import com.javaweb.entity.AccomTypeEntity;
import com.javaweb.service.converter.AccomTypeConverter;
import com.javaweb.service.itface.AccomTypeService;
import com.javaweb.service.model.AccomTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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