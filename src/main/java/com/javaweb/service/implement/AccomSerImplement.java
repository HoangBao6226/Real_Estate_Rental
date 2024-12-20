package com.javaweb.service.implement;

import java.util.*;

import com.javaweb.entity.*;
import com.javaweb.repository.itface.AccomTypeRepository;
import com.javaweb.repository.itface.DetailRTRepository;
import com.javaweb.repository.itface.RentTypeRepository;
import com.javaweb.service.model.lessor.NewAccomDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.repository.custom.AccomRepoCustom;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.service.converter.AccomConverter;
import com.javaweb.service.itface.AccomService;
import com.javaweb.service.model.AccomDTO;

@Service
public class AccomSerImplement implements AccomService {

	@Autowired
	private RentTypeRepository rentTypeRepository;

	@Autowired
	private DetailRTRepository detailRTRepository;

	@Autowired
	private AccomTypeRepository accomTypeRepository;

	@Autowired
	private AccomRepository accomRepo;
	
	@Autowired
	private AccomRepoCustom accomRepoCustom;

	@Autowired
	private AccomConverter accomConverter;

	@Override
	public AccomDTO findAccomById(int id) {

		AccomEntity item = accomRepo.findById(id).get();

		AccomDTO ac = accomConverter.toAccomDTO(item);

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
	public List<AccomDTO> searchAll(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName) {

		List<AccomEntity> listAccomEntity = accomRepoCustom.searchAccom(params, amenityName, rentTypeName);
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();

		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
	}

	@Override
	public List<AccomDTO> searchAllAvailable(Map<String, Object> params, List<String> amenityName, List<String> rentTypeName) {

		List<AccomEntity> listAccomEntity = accomRepoCustom.searchAccomAvailable(params, amenityName, rentTypeName);
		List<AccomDTO> listAccomDTO = new ArrayList<AccomDTO>();

		for(AccomEntity item : listAccomEntity) {
			AccomDTO ac = accomConverter.toAccomDTO(item);
			listAccomDTO.add(ac);
		}
		return listAccomDTO;
	}

	// Thêm accommodation mới
	@Override
	public void addAccom(NewAccomDTO accommodation, LessorEntity lessorID) {

		AccomTypeEntity type = accomTypeRepository.findByType(accommodation.getType());

		AccomEntity ac = new AccomEntity();
		ac.setAccommodationName(accommodation.getAccommodationName());
		ac.setStreet(accommodation.getStreet());
		ac.setWard(accommodation.getWard());
		ac.setDistrict(accommodation.getDistrict());
		ac.setCity(accommodation.getCity());
		ac.setDirection(accommodation.getDirection());
		ac.setSize(accommodation.getSize());
		ac.setNumberOfRooms(accommodation.getNumberOfRooms());
		ac.setStatus(AccomEntity.Status.Pending_Approval);
		ac.setLessorID(lessorID);
		ac.setAccomTypeID(type);
		accomRepo.save(ac);

		List<DetailRentTypeEntity> deRTs = new ArrayList<>();
		for(int i = 0; i < accommodation.getDeRTs().size(); i++) {

			String j = accommodation.getRentTypeName().get(i);
			RentTypeEntity rt = rentTypeRepository.findByRentTypeName(j);
			DetailRentTypeEntity deRT = new DetailRentTypeEntity();
			deRT.setAccommodationID(ac);
			deRT.setRentTypeID(rt);
			deRT.setPrice(accommodation.getDeRTs().get(i).getPrice());
			deRT.setDeposit(accommodation.getDeRTs().get(i).getDeposit());
			deRTs.add(deRT);
		}
		detailRTRepository.saveAll(deRTs);

	}

	// Cập nhật accommodation
	@Transactional
	@Override
	public void updateAccom(int id, NewAccomDTO accommodation, LessorEntity lessorID) {

		AccomTypeEntity type = accomTypeRepository.findByType(accommodation.getType());

		AccomEntity ac = accomRepo.findById(id).get();
		ac.setAccommodationName(accommodation.getAccommodationName());
		ac.setStreet(accommodation.getStreet());
		ac.setWard(accommodation.getWard());
		ac.setDistrict(accommodation.getDistrict());
		ac.setCity(accommodation.getCity());
		ac.setDirection(accommodation.getDirection());
		ac.setSize(accommodation.getSize());
		ac.setNumberOfRooms(accommodation.getNumberOfRooms());
		ac.setStatus(AccomEntity.Status.Pending_Approval);
		ac.setLessorID(lessorID);
		ac.setAccomTypeID(type);
		accomRepo.save(ac);

		detailRTRepository.deleteByAccommodationID(ac);

		List<DetailRentTypeEntity> deRTs = new ArrayList<>();
		for(int i = 0; i < accommodation.getDeRTs().size(); i++) {

			String j = accommodation.getRentTypeName().get(i);
			RentTypeEntity rt = rentTypeRepository.findByRentTypeName(j);
			DetailRentTypeEntity deRT = new DetailRentTypeEntity();
			deRT.setAccommodationID(ac);
			deRT.setRentTypeID(rt);
			deRT.setPrice(accommodation.getDeRTs().get(i).getPrice());
			deRT.setDeposit(accommodation.getDeRTs().get(i).getDeposit());
			deRTs.add(deRT);
		}
		detailRTRepository.saveAll(deRTs);

	}

	// Xóa accommodation
	@Transactional
	@Override
	public void deleteAccom(int id) {

		AccomEntity ac = accomRepo.findById(id).get();
		detailRTRepository.deleteByAccommodationID(ac);
		accomRepo.deleteById(id);
	}

}