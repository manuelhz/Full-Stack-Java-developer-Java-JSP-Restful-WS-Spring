package org.studypro.SpringStarter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studypro.SpringStarter.models.Account;

@Repository
public interface AccountRepository
extends JpaRepository<Account, Long> {
    
}