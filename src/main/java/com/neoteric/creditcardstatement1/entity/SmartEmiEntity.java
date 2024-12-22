package com.neoteric.creditcardstatement1.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmartEmiEntity {
    private int emiId;
    private double principleAmount;
    private int tenureInMonths;
    private double monthlyEmi;
    private LocalDate startDate;
    private LocalDate endDate;
    private TransactionEntity transactionEntity;
}
