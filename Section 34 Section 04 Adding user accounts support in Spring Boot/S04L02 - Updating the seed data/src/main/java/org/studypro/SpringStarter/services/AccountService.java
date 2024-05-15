package org.studypro.SpringStarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studypro.SpringStarter.models.Account;
import org.studypro.SpringStarter.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
