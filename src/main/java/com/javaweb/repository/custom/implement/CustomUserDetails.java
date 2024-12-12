package com.javaweb.repository.custom.implement;

import com.javaweb.entity.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final AccountEntity account;

    public CustomUserDetails(AccountEntity account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String rolePrefix = "ROLE_";
        String roleName = String.valueOf(account.getRoleID().getRoleID());

        switch (roleName) {
            case "1":
                roleName = "MANAGER";
                break;
            case "2":
                roleName = "EMPLOYEE";
                break;
            case "3":
                roleName = "LESSOR";
                break;
            case "4":
                roleName = "LESSEE";
                break;
            default:
                throw new IllegalArgumentException("Invalid role ID: " + roleName);
        }

        return Collections.singletonList(new SimpleGrantedAuthority(rolePrefix + roleName));
    }


    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
