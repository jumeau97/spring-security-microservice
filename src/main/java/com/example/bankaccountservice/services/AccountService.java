package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
     BankAccountResponseDTO save(BankAccountRequestDTO bankAccountRequestDTO);

     BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
