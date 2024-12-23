package com.neoteric.creditcardstatement1.service;

import com.neoteric.creditcardstatement1.dtomodel.CreditCard;
import com.neoteric.creditcardstatement1.dtomodel.Transaction;
import com.neoteric.creditcardstatement1.entity.CreditCardEntity;
import com.neoteric.creditcardstatement1.entity.SmartEmiEntity;
import com.neoteric.creditcardstatement1.entity.TransactionEntity;
import com.neoteric.creditcardstatement1.repository.CreditCardRepository;
import com.neoteric.creditcardstatement1.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private ModelMapper mapper;

//    public CreditCardService(ModelMapper mapper){
//        this.Mapper=mapper;
//
//
//    }
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    public CreditCard convertEntityToDto(CreditCardEntity creditCardEntity){
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CreditCard creditCard= new CreditCard();
        creditCard=mapper.map(creditCardEntity,CreditCard.class);
        return creditCard;

    }
    public void makeTransaction(int creditCardId, Transaction transaction) {
        CreditCardEntity creditCardEntity = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new RuntimeException("Credit Card not found"));

        // Create a TransactionEntity from the DTO
        TransactionEntity transactionEntity = mapper.map(transaction, TransactionEntity.class);
        transactionEntity.setCreditCard(creditCardEntity);
        transactionRepository.save(transactionEntity);

        // Update available credit limit
        creditCardEntity.setAvailableLimit(
                creditCardEntity.getAvailableLimit() - transaction.getTransactionAmount());
        creditCardRepository.save(creditCardEntity);
    }

    public void convertToSmartEmi(int transactionId, double principalAmount, int tenureInMonths) {
        TransactionEntity transactionEntity = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (transactionEntity.isEmi()) {
            throw new RuntimeException("Transaction is already converted to EMI");
        }

        SmartEmiEntity smartEmi = new SmartEmiEntity();
        smartEmi.setPrincipleAmount(principalAmount);
        smartEmi.setTenureInMonths(tenureInMonths);
        smartEmi.setMonthlyEmi(principalAmount / tenureInMonths);
        smartEmi.setStartDate(LocalDate.now());
        smartEmi.setEndDate(LocalDate.now().plusMonths(tenureInMonths));
        smartEmi.setTransactionEntity(transactionEntity);

        transactionEntity.setSmartEmiEntity(smartEmi);
        transactionEntity.setEmi(true);
        transactionRepository.save(transactionEntity);
    }

    public void payOffTransactions(int creditCardId) {
        CreditCardEntity creditCardEntity = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new RuntimeException("Credit Card not found"));

        List<TransactionEntity> transactions = transactionRepository.findByCreditCard(creditCardEntity);

        for (TransactionEntity transaction : transactions) {
            if (!transaction.isEmi()) {
                // Mark the transaction as paid or remove it
                transactionRepository.delete(transaction);

                // Update available credit limit
                creditCardEntity.setAvailableLimit(
                        creditCardEntity.getAvailableLimit() + transaction.getAmount());
            }
        }

        creditCardRepository.save(creditCardEntity);
    }

}
