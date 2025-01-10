package com.javaweb.controller.manager;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.ReservationEntity;
import com.javaweb.repository.itface.ReservationRepository;
import com.javaweb.service.itface.AccomService;
import com.javaweb.service.model.AccomDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/manager")
public class LoadManager_ListAccomController {

	@Autowired
	private AccomService accomSer;

	@GetMapping(value = "/list-accom")
	public String loadListAccom(Model model, HttpServletRequest request) {

		String remoteUser = request.getRemoteUser();

		if(remoteUser != null) {
			String user = remoteUser;
			model.addAttribute("user", user);
		}

		List<AccomEntity> ac = accomSer.findAllAccom();
		model.addAttribute("accommodation", ac);

		return "manager/list-accom";
	}

	@PutMapping(value = "/list-accom/{id}")
	public ResponseEntity<String> updateStatusAccom(@PathVariable int id) {
		accomSer.updateStatusAccom(id); // Gọi service để cập nhật trạng thái
		return ResponseEntity.ok("Accommodation status updated successfully.");
	}


//	@GetMapping(value = "/list-account")
//	public String loadListAccount() {
//
//		return "manager/list-account";
//	}
//
//	@GetMapping(value = "/list-invoice")
//	public String loadListInvoice() {
//
//		return "manager/list-invoice";
//	}
//
//	@GetMapping(value = "/list-reservation")
//	public String loadListReservation(Model model) {
//
//		List<ReservationEntity> re = reservationRepository.findAll();
////		"accommodation" giống như key để gửi qua bên FE
//		model.addAttribute("reser", re);
//		return "manager/list-reservation";
//	}

}