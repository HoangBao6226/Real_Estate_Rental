package com.javaweb.controller.manager;

import com.javaweb.entity.ReservationEntity;
import com.javaweb.repository.itface.ReservationRepository;
import com.javaweb.service.itface.AccomService;
import com.javaweb.service.itface.AccomTypeService;
import com.javaweb.service.itface.AccountService;
import com.javaweb.service.itface.ReservationService;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.AccomTypeDTO;
import com.javaweb.service.model.AccountDTO;
import com.javaweb.service.model.ReservationDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/manager")
public class LoadManagerController {

	@Autowired
	private AccomService accomSer;

	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping(value = "/list-accom")
	public String loadListAccom(Model model) {

		List<AccomDTO> ac = accomSer.findAllAccom();
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", ac);

		return "manager/list-accom";
	}

	@GetMapping(value = "/list-account")
	public String loadListAccount() {

		return "manager/list-account";
	}

	@GetMapping(value = "/list-invoice")
	public String loadListInvoice() {

		return "manager/list-invoice";
	}

	@GetMapping(value = "/list-reservation")
	public String loadListReservation(Model model) {

		List<ReservationEntity> re = reservationRepository.findAll();
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("reser", re);
		return "manager/list-reservation";
	}

}