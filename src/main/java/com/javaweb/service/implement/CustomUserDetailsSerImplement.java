package com.javaweb.service.implement;

import com.javaweb.entity.AccountEntity;
import com.javaweb.repository.custom.implement.CustomUserDetails;
import com.javaweb.repository.itface.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsSerImplement implements UserDetailsService {

    private final AccountRepository accountRepository;

    public CustomUserDetailsSerImplement(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        return new CustomUserDetails(account);
    }
}

