package com.neoteric.creditcardstatement1.entity;
import com.neoteric.creditcardstatement1.dtomodel.CreditCard;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Entity
//@Table
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class AccountEntity {
  //  @Column()
    private String accountNumber;
  //  @Column
    private String accountHolderName;
  //  @Column
    private double accountBalance;
  //  @OneToOne
    private CreditCard creditCard;
}
