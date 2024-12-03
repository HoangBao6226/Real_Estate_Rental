package com.javaweb.repository.custom.implement;

import java.util.*;
import java.util.stream.Collectors;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.repository.custom.AccomRepoCustom;
import com.javaweb.entity.AccomEntity;
import com.javaweb.util.ListUtil;
import com.javaweb.util.NumberUtil;
import com.javaweb.util.StringUtil;

@Repository
public class AccomRepoImplement implements AccomRepoCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public static void joinTableStatus(StringBuilder sql) {

		sql.append(" join detailstatus on accommodation.accommodationID = detailstatus.accommodationID");
	}

	public static void joinTableAccom(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName, StringBuilder sql) {

		boolean flag = false;
		String minPrice = (String) params.get("minPrice");
		String maxPrice = (String) params.get("maxPrice");
		if (StringUtil.checkString(minPrice) || StringUtil.checkString(maxPrice)) {
			sql.append(" join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID");
			flag = true;
		}

		if (ListUtil.checkList(amenityName))
			sql.append(" join detailamenity on accommodation.accommodationID = detailamenity.accommodationID"
					+ " join amenity on detailamenity.amenityID = amenity.amenityID");

		if (ListUtil.checkList(rentTypeName)) {
			if (flag)
				sql.append(" join renttype on detailrenttype.renttypeID = renttype.renttypeID");
			else
				sql.append(" join detailrenttype on accommodation.accommodationID = detailrenttype.accommodationID"
						+ " join renttype on detailrenttype.renttypeID = renttype.renttypeID");
		}

	}

	public static void queryNormal(Map<String, Object> params, StringBuilder where) {

		for (Map.Entry<String, Object> item : params.entrySet()) {
			if (!item.getKey().equals("amenityName") && !item.getKey().equals("rentTypeName")
					&& !item.getKey().endsWith("Size") && !item.getKey().endsWith("Price")) {
				String value = item.getValue().toString();
				if (StringUtil.checkString(value)) {
					if (NumberUtil.isNumber(value))
						where.append(" AND " + item.getKey() + " = " + value);
					else
						where.append(" AND " + item.getKey() + " LIKE '%" + value + "%'");
				}
			}
		}
	}

	public static void querySpecial(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName, StringBuilder where) {

		String minPrice = (String) params.get("minPrice");
		if (StringUtil.checkString(minPrice))
			where.append(" AND price >= " + minPrice);

		String maxPrice = (String) params.get("maxPrice");
		if (StringUtil.checkString(maxPrice))
			where.append(" AND price <= " + maxPrice);

		String minSize = (String) params.get("minSize");
		if (StringUtil.checkString(minSize))
			where.append(" AND size >= " + minSize);

		String maxSize = (String) params.get("maxSize");
		if (StringUtil.checkString(maxSize))
			where.append(" AND size <= " + maxSize);

//		if(ListUtil.checkList(amenityName)) {
//			List<String> amenity = new ArrayList<String>();
//			for (String item : amenityName)
//				amenity.add("'" + item + "'");
//			where.append(" AND amenityName IN (" + String.join(", ", amenity) + ")");
//		}
//
//		if(ListUtil.checkList(rentTypeName)) {
//			List<String> rentType = new ArrayList<String>();
//			for (String item : rentTypeName)
//				rentType.add("'" + item + "'");
//			where.append(" AND rentTypeName IN (" + String.join(", ", rentType) + ")");
//		}

		if (ListUtil.checkList(amenityName)) {
			where.append(" AND (");
			String sql = amenityName.stream().map(it -> "amenityName like" + "'%" + it + "%'")
					.collect(Collectors.joining(" or "));
			where.append(sql);
			where.append(" ) ");
		}

		if (ListUtil.checkList(rentTypeName)) {
			where.append(" AND (");
			String sql = rentTypeName.stream().map(it -> "rentTypeName like" + "'%" + it + "%'")
					.collect(Collectors.joining(" or "));
			where.append(sql);
			where.append(" ) ");
		}

	}

	@Override
	public List<AccomEntity> findAllAccomAvailable() {

		StringBuilder sql = new StringBuilder("select accommodation.accommodationID, accommodationName, street, ward, district, city, province, size, numberOfRooms, lessorID, direction, accomTypeID from accommodation ");
		joinTableStatus(sql);
		StringBuilder where = new StringBuilder(" where detailstatus.statusID = 1 ");
		sql.append(where);
		Query query = entityManager.createNativeQuery(sql.toString(), AccomEntity.class);

		return query.getResultList();
	}

	@Override
	public List<AccomEntity> findRandomAccomAvailable() {

		Set<Integer> randomIdsSet = new HashSet<>();
		while (randomIdsSet.size() < 3) {
			randomIdsSet.add((int) (Math.random() * 15 + 1));
		}
		List<Integer> randomIds = new ArrayList<>(randomIdsSet);

		StringBuilder sql = new StringBuilder("select accommodation.accommodationID, accommodationName, street, ward, district, city, province, size, numberOfRooms, lessorID, direction, accomTypeID from accommodation ");
		joinTableStatus(sql);
		StringBuilder where = new StringBuilder(" where detailstatus.statusID = 1 ORDER BY RAND() LIMIT 3");
		sql.append(where);
		System.out.println(sql.toString());
		Query query = entityManager.createNativeQuery(sql.toString(), AccomEntity.class);

		return query.getResultList();
	}

	@Override
	public List<AccomEntity> searchAccom(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName) {

		StringBuilder sql = new StringBuilder("select * from accommodation ");
		joinTableAccom(params, amenityName, rentTypeName, sql);
		StringBuilder where = new StringBuilder(" where 1 = 1 ");
		queryNormal(params, where);
		querySpecial(params, amenityName, rentTypeName, where);
		sql.append(where);
		sql.append(" group by accommodation.accommodationID");

		Query query = entityManager.createNativeQuery(sql.toString(), AccomEntity.class);

		return query.getResultList();
	}

}