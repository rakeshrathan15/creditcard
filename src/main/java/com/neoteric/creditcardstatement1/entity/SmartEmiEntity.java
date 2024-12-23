package com.neoteric.creditcardstatement1.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "smartemi",schema = "creditcard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmartEmiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emiId;

    @Column
    private double principleAmount;
    private int tenureInMonths;
    private double monthlyEmi;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "transactionid",referencedColumnName = "transactionid")
    private TransactionEntity transactionEntity;
}
