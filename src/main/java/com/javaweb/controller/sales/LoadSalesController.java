package com.javaweb.controller.sales;

import com.javaweb.service.itface.AccountService;
import com.javaweb.service.itface.sales.Sales_ReservationService;
import com.javaweb.service.model.AccountDTO;
import com.javaweb.service.model.sales.Sales_ReservationDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class LoadSalesController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private Sales_ReservationService salesService;

	@GetMapping(value = "/list-reservation")
	public String loadListReservation(Model model, HttpServletRequest request) {

		// Kiểm tra #request.remoteUser
		String remoteUser = request.getRemoteUser();

		AccountDTO user = accountService.findByUsername(remoteUser);

		// Đưa thông tin người dùng vào model để sử dụng trong view
		model.addAttribute("user", user);

		List<Sales_ReservationDTO> saRe = salesService.findBySalesID(user.getUsername());

		model.addAttribute("saRe", saRe);

		return "sales/list-reservation";
	}

}