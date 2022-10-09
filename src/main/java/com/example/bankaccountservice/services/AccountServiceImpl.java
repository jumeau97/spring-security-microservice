package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.AccountMapper;
import com.example.bankaccountservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO save(BankAccountRequestDTO bankAccountRequestDTO) {
        //Mapping relationnel

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createDate(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType()).
                build();


        //BankAccount bankAccount = accountMapper.toBankAccount(bankAccountRequestDTO);
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
       /* BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .balance(saveBankAccount.getBalance())
                .createDate(saveBankAccount.getCreateDate())
                .type(saveBankAccount.getType())
                .currency(saveBankAccount.getCurrency())
                .build();
        */
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        //Mapping relationnel

        BankAccount bankAccount = accountMapper.toBankAccount(id, bankAccountRequestDTO);
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
