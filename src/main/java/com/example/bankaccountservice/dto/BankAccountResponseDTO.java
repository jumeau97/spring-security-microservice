package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createDate;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
