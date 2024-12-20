package com.javaweb.controller;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.InvoiceEntity;
import com.javaweb.entity.LesseeEntity;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.InvoiceRepository;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.service.implement.EmailService;
import com.javaweb.service.implement.PaymentService;
import com.javaweb.service.itface.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EmailService emailService;

    @PostMapping(path = "/create_payment")
    public void createPayment(HttpServletRequest req,
                              HttpServletResponse res,
                              HttpSession session,
                              @RequestParam Map<String, Object> params) throws IOException {

        session.setAttribute("accommodationID", params.get("accommodationID"));
        session.setAttribute("rentTypeID", params.get("rentTypeID"));
        session.setAttribute("price", params.get("price"));
        session.setAttribute("deposit", params.get("deposit"));
        session.setAttribute("startDate", params.get("startDate"));
        session.setAttribute("endDate", params.get("endDate"));

        String deposit = (String) session.getAttribute("deposit");
        int amount = Integer.parseInt(deposit);
        String payment = paymentService.createPayment(req, amount);

        res.sendRedirect(payment);

    }

    @GetMapping("/vn-pay-callback")
    public void payCallbackHandler(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Lấy thông tin từ callback URL
        String responseCode = request.getParameter("vnp_ResponseCode");

        // Giao dịch thành công
        if ("00".equals(responseCode)) {
            // Lấy thông tin người dùng hiện tại
            String remoteUser = request.getRemoteUser();

            // Lấy email của người dùng
            String email = accountService.findEmail(remoteUser);

            Map<String, Object> params = new HashMap<>();
            params.put("accommodationID", session.getAttribute("accommodationID"));
            params.put("rentTypeID", session.getAttribute("rentTypeID"));
            params.put("price", session.getAttribute("price"));
            params.put("deposit", session.getAttribute("deposit"));
            params.put("startDate", session.getAttribute("startDate"));
            params.put("endDate", session.getAttribute("endDate"));

            InvoiceEntity in = invoiceService.saveInvoice(params, remoteUser, true);

            String amount = request.getParameter("vnp_Amount");
            int deposit = Integer.parseInt(amount);

            emailService.sendPaymentEmail(email, in.getInvoiceID(), deposit);

            // Chuyển hướng về trang chủ
            response.sendRedirect("/");
        } else {
            // Chuyển hướng về trang chủ
            response.sendRedirect("/");
        }
    }
}
