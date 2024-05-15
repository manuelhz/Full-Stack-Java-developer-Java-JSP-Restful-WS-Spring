package org.studypro.SpringBlog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studypro.SpringBlog.models.Account;

@Repository
public interface AccountRepository
extends JpaRepository<Account, Long> {
    Optional<Account> findOneByEmailIgnoreCase(String username);
    
}