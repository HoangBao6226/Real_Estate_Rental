package com.javaweb.service.implement;

import com.javaweb.entity.AccountEntity;
import com.javaweb.entity.EmployeeEntity;
import com.javaweb.entity.LesseeEntity;
import com.javaweb.entity.LessorEntity;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.EmployeeRepository;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.repository.itface.LessorRepository;
import com.javaweb.service.itface.AccountService;
import com.javaweb.service.model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSerImplement implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private LessorRepository lessorRepository;

    @Override
    public AccountDTO findByUsername(String username) {

        AccountEntity accountEntity = accountRepository.findByUsername(username);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(accountEntity.getUsername());
        accountDTO.setPassword(accountEntity.getPassword());
        return accountDTO;
    }

    @Override
    public String sendPaymentEmail(String username) {

        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if(accountEntity.getEmployeeID() != null) {
            EmployeeEntity em = employeeRepository.findById(accountEntity.getEmployeeID().getEmployeeID()).get();
            return em.getEmail();
        }
        if(accountEntity.getLesseeID() != null) {
            LesseeEntity em = lesseeRepository.findById(accountEntity.getLesseeID().getLesseeID()).get();
            return em.getEmail();
        }
        if(accountEntity.getLessorID() != null) {
            LessorEntity em = lessorRepository.findById(accountEntity.getLessorID().getLessorID()).get();
            return em.getEmail();
        }
        return "";
    }
}
