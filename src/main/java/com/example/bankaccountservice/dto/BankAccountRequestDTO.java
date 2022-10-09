package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
    