package com.neoteric.creditcardstatement1.dtomodel;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
   private String holderName;
   private String cardNumber;
   private String cvv;
   private LocalDate cardExpiryDate;
    private double creditLimit;
    private List<Transaction> transactionList= new ArrayList<>();
}
