package com.javaweb.repository.itface;

import com.javaweb.entity.AccountEntity;
import com.javaweb.entity.LesseeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    AccountEntity findByUsername(String username);

    AccountEntity findByLesseeID(LesseeEntity lesseeEntity);
}
