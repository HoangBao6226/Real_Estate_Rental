package com.javaweb.service.itface;

import java.util.List;
import java.util.Map;


import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.LessorEntity;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.lessor.NewAccomDTO;

public interface AccomService {

	AccomDTO findAccomById(int id);

	List<AccomEntity> findAllAccom();

	List<AccomDTO> findAllAccomAvailable();

	List<AccomDTO> findRandomAccomAvailable();

	List<AccomDTO> searchAll(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName);

	List<AccomDTO> searchAllAvailable(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName);

	void addAccom(NewAccomDTO accommodation, LessorEntity lessorID);

	void updateAccom(int id, NewAccomDTO accommodation, LessorEntity lessorID);

	void deleteAccom(int id);

	boolean checkAccomAvailability(int accomId);

	void updateStatusAccom(int accomId);
}