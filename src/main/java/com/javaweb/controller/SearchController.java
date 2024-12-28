package com.javaweb.controller;

import java.util.List;
import java.util.Map;

import com.javaweb.service.itface.AccountService;
import com.javaweb.service.model.AccountDTO;
import com.javaweb.util.Pagination;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javaweb.service.itface.AccomService;
import com.javaweb.service.model.AccomDTO;

@Controller
public class SearchController {

    @Autowired
    private AccomService accomSer;

    @Autowired
    private AccountService accountService;

	@GetMapping(value = "/propertiesSearch")
	public String searchAccom(Model model, HttpServletRequest request,
                                @RequestParam Map<String, Object> params,
                                @RequestParam (name = "amenityName", required = false) List<String> amenityName,
                                @RequestParam (name = "rentTypeName", required = false) List<String> rentTypeName,
                                @RequestParam (name = "page", defaultValue = "1") int page) {
        // Kiểm tra #request.remoteUser
        String remoteUser = request.getRemoteUser();

        if(remoteUser != null) {
            // Bạn có thể truy vấn thông tin từ database dựa trên username
            // Giả sử bạn có một service để lấy thông tin người dùng
            AccountDTO user = accountService.findByUsername(remoteUser);

            // Đưa thông tin người dùng vào model để sử dụng trong view
            model.addAttribute("user", user);
        }

//		"accommodation" giống như key để gửi qua bên FE
        List<AccomDTO> acSearch = accomSer.searchAllAvailable(params, amenityName, rentTypeName);
        Pagination pagination = new Pagination();
        List<AccomDTO> pagedAccommodation = pagination.getPagedList(acSearch, page);
        int totalPages = pagination.getTotalPages(acSearch);
        model.addAttribute("pagedAccommodation", pagedAccommodation);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "propertiesSearch";
	}
}