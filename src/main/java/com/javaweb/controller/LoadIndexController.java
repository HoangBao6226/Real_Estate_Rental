package com.javaweb.controller;

import com.javaweb.service.itface.AccomService;
import com.javaweb.service.itface.AccomTypeService;
import com.javaweb.service.itface.AccountService;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.AccomTypeDTO;
import com.javaweb.service.model.AccountDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class LoadIndexController {

	@Autowired
	private AccomTypeService accomTypeSer;

	@Autowired
	private AccomService accomSer;

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/")
	public String loadIndex(Model model, HttpServletRequest request) {

		// Kiểm tra #request.remoteUser
		String remoteUser = request.getRemoteUser();

		if(remoteUser != null) {
			// Bạn có thể truy vấn thông tin từ database dựa trên username
			// Giả sử bạn có một service để lấy thông tin người dùng
			AccountDTO user = accountService.findByUsername(remoteUser);

			// Đưa thông tin người dùng vào model để sử dụng trong view
			model.addAttribute("user", user);
		}

		List<AccomTypeDTO> acDTO = accomTypeSer.findAllAccomType();
//		"____" giống như key để gửi qua bên FE
		model.addAttribute("accomType", acDTO);

		List<AccomDTO> ac = accomSer.findRandomAccomAvailable();
//		"accommodation" giống như key để gửi qua bên FE
		model.addAttribute("accommodation", ac);

		return "index";
	}

}