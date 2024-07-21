package com.banking.banking.repository;

import com.banking.banking.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Account a WHERE a.id BETWEEN :minValue AND :maxValue")
    void deleteByIdRange(@Param("minValue") Long minValue, @Param("maxValue") Long maxValue);
}
