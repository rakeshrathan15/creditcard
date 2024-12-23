package com.neoteric.creditcardstatement1;

import com.neoteric.creditcardstatement1.dtomodel.CreditCard;
import com.neoteric.creditcardstatement1.dtomodel.SmartEmi;
import com.neoteric.creditcardstatement1.dtomodel.Transaction;
import com.neoteric.creditcardstatement1.service.CreditCardService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
@EntityScan(basePackages = "com.neoteric.creditcardstatement1.entity")
public class Creditcardstatement1Application {

	@Bean
	public ModelMapper mapper(){
		return  new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(Creditcardstatement1Application.class, args);

//		ModelMapper mapper = new ModelMapper();
//		CreditCardService creditCardService = new CreditCardService();
//
//		// Create a sample CreditCard with initial details
//		CreditCard creditCard = CreditCard.builder()
//				.holderName("John Doe")
//				.cardNumber("1234-5678-9876-5432")
//				.cvv("123")
//				.cardExpiryDate(LocalDate.of(2030, 12, 31))
//				.creditLimit(5000)
//				.transactionList(new ArrayList<>())
//				.build();
//
//		System.out.println("Initial Credit Card Details: " + creditCard);
//
//		// Simulate 10 Transactions
//		for (int i = 1; i <= 10; i++) {
//			Transaction transaction = Transaction.builder()
//					.transactionId(i)
//					.transactionType("Purchase")
//					.transactionDate(LocalDate.now())
//					.transactionAmount(100 + i * 10) // Increment amount for each transaction
//					.description("Transaction " + i)
//					.convertedToEmi(false)
//					.build();
//			creditCard.getTransactionList().add(transaction);
//		}
//		System.out.println("After Adding 10 Transactions: " + creditCard.getTransactionList());
//
//		// Convert a transaction to Smart EMI
//		Transaction transactionToConvert = creditCard.getTransactionList().get(5); // Select the 6th transaction
//		SmartEmi smartEmi = SmartEmi.builder()
//				.principalAmount(transactionToConvert.getTransactionAmount())
//				.tenureInMonths(12)
//				.monthlyEmi(transactionToConvert.getTransactionAmount() / 12)
//				.startDate(LocalDate.now())
//				.endDate(LocalDate.now().plusMonths(12))
//				.build();
//		transactionToConvert.setConvertedToEmi(true);
//		transactionToConvert.setEmi(smartEmi);
//		System.out.println("After Converting Transaction to Smart EMI: " + transactionToConvert);
//
//		// Pay off remaining transactions
//		double totalPayable = creditCard.getTransactionList().stream()
//				.filter(transaction -> !transaction.isConvertedToEmi())
//				.mapToDouble(Transaction::getTransactionAmount)
//				.sum();
//		System.out.println("Total Payable for Non-EMI Transactions: " + totalPayable);
//		System.out.println("Available Limit Before Payment: " + creditCard.getCreditLimit());
//
//		// Update credit limit after payment
//		creditCard.setCreditLimit(creditCard.getCreditLimit() + totalPayable);
//		creditCard.getTransactionList().removeIf(transaction -> !transaction.isConvertedToEmi());
//		System.out.println("Available Limit After Payment: " + creditCard.getCreditLimit());
//		System.out.println("Remaining Transactions: " + creditCard.getTransactionList());
	}

}