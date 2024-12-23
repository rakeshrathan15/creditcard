package com.neoteric.creditcardstatement1.repository;

import com.neoteric.creditcardstatement1.entity.CreditCardEntity;
import com.neoteric.creditcardstatement1.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {

   // List<TransactionEntity> findByCreditCardEntity(CreditCardEntity creditCardEntity);

    List<TransactionEntity> findByCreditCard(CreditCardEntity creditCardEntity);

}
