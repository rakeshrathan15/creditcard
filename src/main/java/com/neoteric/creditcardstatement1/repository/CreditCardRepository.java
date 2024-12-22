package com.neoteric.creditcardstatement1.repository;

import com.neoteric.creditcardstatement1.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Integer> {



}
