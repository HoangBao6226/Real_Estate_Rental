package com.javaweb.controller;

import com.javaweb.service.implement.EmailService;
import com.javaweb.service.implement.PaymentService;
import com.javaweb.service.itface.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService invoiceService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/vn-pay-callback")
    public void payCallbackHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String status = request.getParameter("vnp_ResponseCode");
        String username = request.getRemoteUser(); // Lấy username của người dùng đã đăng nhập

        // Truy vấn thông tin người dùng từ cơ sở dữ liệu
//        AccountDTO user = accountService.findByUsername(username); // Giả sử bạn có UserService với phương thức findByUsername

        if ("00".equals(status)) {
            // Xử lý thanh toán thành công
            String email = accountService.sendPaymentEmail(username); // Lấy email của người dùng
            String subject = "Payment Notification";
            emailService.sendPaymentEmail(email, subject);

            // Chuyển hướng về trang chủ
            response.sendRedirect("/");
        } else {
            // Xử lý thanh toán thất bại
            String email = accountService.sendPaymentEmail(username); // Lấy email của người dùng
            String subject = "Your payment failed. Please try again.\"";
            emailService.sendPaymentEmail(email, subject);

            // Chuyển hướng về trang chủ hoặc trang lỗi
            response.sendRedirect("/");
        }
    }

    @GetMapping("/create_payment")
    public void createPayment(@RequestParam("amount") long amount, HttpServletRequest req, HttpServletResponse res) throws IOException {

        String in = invoiceService.createPayment(req, amount);
        res.sendRedirect(in);

    }
}
