package com.javaweb.service.itface;

import com.javaweb.entity.InvoiceEntity;

import java.util.Map;

public interface InvoiceService {

    InvoiceEntity saveInvoice(Map<String, Object> params, String username, boolean isPaymentSuccessful);

}
