package com.neoteric.creditcardstatement1.dtomodel;
import lombok.*;
import java.time.LocalDate;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmartEmi {
 private double principalAmount;
 private int tenureInMonths;
 private double monthlyEmi;
 private LocalDate startDate;
 private LocalDate endDate;
}
