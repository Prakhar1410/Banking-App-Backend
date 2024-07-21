package com.banking.banking.service.impl;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.entity.Account;
import com.banking.banking.mapper.AccountMapper;
import com.banking.banking.repository.AccountRepository;
import com.banking.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account doesn't exists"));
        return AccountMapper.mapToAccountDto(account);
    }

}
