package com.javaweb.controller;

import com.javaweb.entity.InvoiceEntity;
import com.javaweb.service.implement.EmailService;
import com.javaweb.service.implement.PaymentService;
import com.javaweb.service.itface.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static LocalDateTime startDate;
    private static LocalDateTime endDate;
    private static int accomID;
    private static int inID;
    private static int amount;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DetailStatusService detailStatusService;

    @Autowired
    private EmailService emailService;

    @PostMapping(path = "/create_payment")
    public void createPayment(HttpServletRequest req,
                              HttpServletResponse res,
                              @RequestParam Map<String, Object> params) throws IOException {

        String remoteUser = req.getRemoteUser();

        String acID = (String) params.get("accommodationID");
        accomID = Integer.parseInt(acID);
        detailStatusService.updateStatusUnavailable(accomID);

        String start = (String) params.get("startDate");
        startDate = LocalDateTime.parse(start);

        String end = (String) params.get("endDate");
        endDate = LocalDateTime.parse(end);

        InvoiceEntity inE =  invoiceService.saveInvoice(params, remoteUser);
        inID = inE.getInvoiceID();

        String deposit = (String) params.get("deposit");
        amount = Integer.parseInt(deposit);
        String in = paymentService.createPayment(req, amount);

        res.sendRedirect(in);

    }


    @GetMapping("/vn-pay-callback")
    public void payCallbackHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Lấy thông tin từ callback URL
        String responseCode = request.getParameter("vnp_ResponseCode");

        // Lấy thông tin người dùng hiện tại
        String remoteUser = request.getRemoteUser();

        if ("00".equals(responseCode)) {
            // Giao dịch thành công
            detailStatusService.updateStatusOccupied(accomID, startDate, endDate);
            // Lấy email của người dùng
            String email = accountService.findEmail(remoteUser);
            emailService.sendPaymentEmail(email, inID, amount);

            // Chuyển hướng về trang chủ
            response.sendRedirect("/");
        } else {
            // Giao dịch thất bại
            detailStatusService.updateStatusAvailable(accomID);
            // Cập nhật status Invoive In_progress -> Canceled
            invoiceService.updateStatusCanceled(inID);
            // Chuyển hướng về trang chủ
            response.sendRedirect("/");
        }
    }
}
