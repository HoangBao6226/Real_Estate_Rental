package com.javaweb.controller.lessor;

import com.javaweb.entity.*;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.AccomTypeRepository;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.LessorRepository;
import com.javaweb.service.itface.AccomService;
import com.javaweb.service.model.lessor.NewAccomDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lessor/list-accom")
public class LoadListAccomController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccomRepository accomRepository;

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private AccomService accommodationService;

    @GetMapping
    public String loadListReservation(Model model, HttpServletRequest request) {

        // Kiểm tra #request.remoteUser
        String remoteUser = request.getRemoteUser();

        LessorEntity lessorEntity = new LessorEntity();

        if(remoteUser != null) {
            // Bạn có thể truy vấn thông tin từ database dựa trên username
            // Giả sử bạn có một service để lấy thông tin người dùng
            AccountEntity user = accountRepository.findByUsername(remoteUser);

            // Đưa thông tin người dùng vào model để sử dụng trong view
            model.addAttribute("user", user);

            lessorEntity = lessorRepository.findById(user.getLessorID().getLessorID()).get();
        }

        List<AccomEntity> ac = accomRepository.findAllByLessorID(lessorEntity);
        // "accommodation" giống như key để gửi qua bên FE
        model.addAttribute("accommodation", ac);

        return "lessor/list-accom";
    }

    // Thêm accommodation mới
    @PostMapping
    public void addAccomEntity(@RequestBody NewAccomDTO accommodation, HttpServletRequest request) {

        // Kiểm tra #request.remoteUser
        String remoteUser = request.getRemoteUser();

        LessorEntity lessorEntity = new LessorEntity();

        if(remoteUser != null) {
            // Bạn có thể truy vấn thông tin từ database dựa trên username
            // Giả sử bạn có một service để lấy thông tin người dùng
            AccountEntity user = accountRepository.findByUsername(remoteUser);

            lessorEntity = lessorRepository.findById(user.getLessorID().getLessorID()).get();
        }

        accommodationService.addAccom(accommodation, lessorEntity);

    }

    // Cập nhật accommodation
    @PutMapping("/{id}")
    public void updateAccomEntity(@PathVariable int id, @RequestBody NewAccomDTO accommodation, HttpServletRequest request) {

        // Kiểm tra #request.remoteUser
        String remoteUser = request.getRemoteUser();

        LessorEntity lessorEntity = new LessorEntity();

        if(remoteUser != null) {
            // Bạn có thể truy vấn thông tin từ database dựa trên username
            // Giả sử bạn có một service để lấy thông tin người dùng
            AccountEntity user = accountRepository.findByUsername(remoteUser);

            lessorEntity = lessorRepository.findById(user.getLessorID().getLessorID()).get();
        }

        accommodationService.updateAccom(id, accommodation, lessorEntity);
    }

    // Xóa accommodation theo rentType
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccomEntity(@PathVariable int id) {
        accommodationService.deleteAccom(id);
        return ResponseEntity.noContent().build(); // Trả về HTTP 204
    }
}
