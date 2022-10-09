package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component // OR @Service
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount (BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount toBankAccount(String id, BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(id);
        bankAccount.setCreateDate(new Date());
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }
}
