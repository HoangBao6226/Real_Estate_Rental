package com.javaweb.service.implement;

import com.javaweb.entity.AccountEntity;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.service.itface.AccountService;
import com.javaweb.service.model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSerImplement implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDTO findByUsername(String username) {

        AccountEntity accountEntity = accountRepository.findByUsername(username);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(accountEntity.getUsername());
        accountDTO.setPassword(accountEntity.getPassword());
        return accountDTO;
    }
}
