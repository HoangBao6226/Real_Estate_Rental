package com.javaweb.controller;

import com.javaweb.service.itface.AccomService;
import com.javaweb.service.itface.AccountService;
import com.javaweb.service.itface.DetailRTService;
import com.javaweb.service.itface.RentTypeService;
import com.javaweb.service.model.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoadInvoiceController {

	@Autowired
	private AccomService accomSer;

	@Autowired
	private AccountService accountService;

	@Autowired
	private DetailRTService detailRTService;

	@Autowired
	private RentTypeService rentTypeService;

	@GetMapping(value = "/invoice")
	public String loadProperty(Model model, HttpServletRequest request,
							   @RequestParam(name = "accommodationID") int accommodationID,
							   @RequestParam(name = "renttype") String renttype) {

		// Kiểm tra #request.remoteUser
		String remoteUser = request.getRemoteUser();

		if(remoteUser != null) {
			// Bạn có thể truy vấn thông tin từ database dựa trên username
			// Giả sử bạn có một service để lấy thông tin người dùng
			AccountDTO user = accountService.findByUsername(remoteUser);

			// Đưa thông tin người dùng vào model để sử dụng trong view
			model.addAttribute("user", user);
		}

		AccomDTO ac = accomSer.findAccomById(accommodationID);
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", ac);

		RentTypeDTO rt = rentTypeService.findRentTypeByName(renttype);
		model.addAttribute("rentType", rt);

		DetailRTDTO rtdto = detailRTService.findByAccomIDAndRTName(accommodationID, renttype);
		model.addAttribute("detailRT", rtdto);

		return "invoice";
	}

}