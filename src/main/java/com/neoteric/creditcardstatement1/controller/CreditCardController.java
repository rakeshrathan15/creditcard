package com.neoteric.creditcardstatement1.controller;

import com.neoteric.creditcardstatement1.dtomodel.Transaction;
import com.neoteric.creditcardstatement1.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getCreditCard(@PathVariable int id) {
        return ResponseEntity.ok("Credit Card Details for ID: " + id);
    }

    @PostMapping("api/creditcards/{id}/transactions")
    public ResponseEntity<String> makeTransaction(
            @PathVariable int id, @RequestBody Transaction transaction) {
        creditCardService.makeTransaction(id, transaction);
        return ResponseEntity.ok("Transaction added successfully");
    }

    @PostMapping("/transactions/{transactionId}/convertToEmi")
    public ResponseEntity<String> convertToSmartEmi(
            @PathVariable int transactionId, @RequestParam double principalAmount, @RequestParam int tenureInMonths) {
        creditCardService.convertToSmartEmi(transactionId, principalAmount, tenureInMonths);
        return ResponseEntity.ok("Transaction converted to EMI successfully");
    }

    @PostMapping("/{id}/payOffTransactions")
    public ResponseEntity<String> payOffTransactions(@PathVariable int id) {
        creditCardService.payOffTransactions(id);
        return ResponseEntity.ok("Remaining transactions paid off successfully");
    }

}
