package com.neoteric.creditcardstatement1.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "creditcard",schema = "creditcard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditCardId;

    @Column(name = "holdername")
    private String holderName;

    @Column(name = "cardnumber")
    private String cardNumber;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "cardExpiryDate")
    private LocalDate cardExpiryDate;

    @Column(name = "creditLimit")
    private double creditLimit;

    @Column(name = "availableLimit")
    private double availableLimit;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactionEntityList;


}
