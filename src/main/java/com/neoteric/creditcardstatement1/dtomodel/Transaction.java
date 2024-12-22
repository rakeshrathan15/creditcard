package com.neoteric.creditcardstatement1.dtomodel;
import lombok.*;
import java.time.LocalDate;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int transactionId;
    private String transactionType;
    private LocalDate transactionDate;
    private double transactionAmount;
    private String description;
    private boolean convertedToEmi;
    private SmartEmi emi;
}
