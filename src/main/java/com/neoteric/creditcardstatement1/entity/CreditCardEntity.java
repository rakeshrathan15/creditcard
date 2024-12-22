package com.neoteric.creditcardstatement1.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardEntity {
    private int creditCardId;
    private String holderName;
    private String cardNumber;
    private String cvv;
    private LocalDate cardExpiryDate;
    private double creditLimit;
    private double availableLimit;
    private List<TransactionEntity> transactionEntityList;
    private List<MonthlyBIllStatementEntity> monthlyBillStatement;
}
