package com.neoteric.creditcardstatement1.service;

import com.neoteric.creditcardstatement1.dtomodel.Account;
import com.neoteric.creditcardstatement1.entity.AccountEntity;
import com.neoteric.creditcardstatement1.util.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

@Autowired
    AccountMapper accountMapper;

    public void account(Account account){

      //     AccountEntity accountEntity=accountMapper.toEntity(account);


    }



}
