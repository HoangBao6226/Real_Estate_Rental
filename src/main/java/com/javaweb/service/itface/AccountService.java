package com.javaweb.service.itface;

import com.javaweb.service.model.AccountDTO;

public interface AccountService {

    AccountDTO findByUsername(String username);

    String sendPaymentEmail(String username);
}
