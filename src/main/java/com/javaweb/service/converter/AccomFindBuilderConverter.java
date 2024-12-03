package com.javaweb.service.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.repository.builder.AccomFindBuilder;
import com.javaweb.util.MapUtil;

@Component
public class AccomFindBuilderConverter {

	public AccomFindBuilder toAccomFindBuider(Map<String, Object> params, List<String> amenityName,
			List<String> rentTypeName) {

		AccomFindBuilder ac = new AccomFindBuilder.Builder()
				.setAccommodationName(MapUtil.getObject(params, "accommodationName", String.class))
				.setStreet(MapUtil.getObject(params, "street", String.class))
				.setWard(MapUtil.getObject(params, "ward", String.class))
				.setDistrict(MapUtil.getObject(params, "district", String.class))
				.setCity(MapUtil.getObject(params, "city", String.class))
				.setProvince(MapUtil.getObject(params, "province", String.class))
				.setDirection(MapUtil.getObject(params, "direction", String.class))
				.setSize(MapUtil.getObject(params, "size", Float.class))
				.setNumberOfRooms(MapUtil.getObject(params, "numberOfRooms", Integer.class))
				.setAmenityName(amenityName)
				.setRentTypeName(rentTypeName)
				.build();
		return ac;
	}
}

