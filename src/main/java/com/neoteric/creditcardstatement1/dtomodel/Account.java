package com.neoteric.creditcardstatement1.dtomodel;


import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {


   private String accountNumber;

   private String accountHolderName;

   private double accountBalance;

   private CreditCard creditCard;





}
