package org.studypro.SpringBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studypro.SpringBlog.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
    
}
