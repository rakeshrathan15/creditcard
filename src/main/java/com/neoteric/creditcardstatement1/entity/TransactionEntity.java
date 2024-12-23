package com.neoteric.creditcardstatement1.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "transaction",schema = "creditcard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "transactionId")
   private int transactionId;

   @Column(name = "transactiontype")
   private String transactionType;

   @Column(name = "transactionDate")
   private LocalDate transactionDate;

   @Column(name = "amount")
   private double amount;

   @Column(name = "isEmi")
   private boolean isEmi;

   @ManyToOne
   @JoinColumn(name = "creditcardId",referencedColumnName = "creditcardId")
   private CreditCardEntity creditCard;

   @OneToOne(mappedBy = "transactionEntity",cascade = CascadeType.ALL)
   private SmartEmiEntity smartEmiEntity;
}
