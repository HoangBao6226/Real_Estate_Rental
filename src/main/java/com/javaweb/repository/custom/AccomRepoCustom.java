package com.javaweb.repository.custom;

import java.util.List;
import java.util.Map;

import com.javaweb.entity.AccomEntity;

public interface AccomRepoCustom {

	List<AccomEntity> findAllAccomAvailable();

	List<AccomEntity> findRandomAccomAvailable();

	List<AccomEntity> searchAccom(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName);
}
