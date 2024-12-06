package com.javaweb.repository.itface;

import com.javaweb.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    AccountEntity findByUsername(String username);

    AccountEntity findByPassword(String password);
}
