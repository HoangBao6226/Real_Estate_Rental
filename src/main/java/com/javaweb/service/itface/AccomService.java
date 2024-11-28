package com.javaweb.service.itface;

import java.util.List;
import java.util.Map;


import com.javaweb.service.model.AccomDTO;

public interface AccomService {

	List<AccomDTO> findAllAccom();
	
	List<AccomDTO> findAll(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName);


}