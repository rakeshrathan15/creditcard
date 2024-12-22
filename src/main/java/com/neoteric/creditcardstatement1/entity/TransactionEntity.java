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
public class TransactionEntity {
   private int transactionId;
   private String transactionType;
   private LocalDate transactionDate;
   private double amount;
   private boolean isEmi;
   private CreditCardEntity creditCardEntity;
   private SmartEmiEntity smartEmiEntity;
}
