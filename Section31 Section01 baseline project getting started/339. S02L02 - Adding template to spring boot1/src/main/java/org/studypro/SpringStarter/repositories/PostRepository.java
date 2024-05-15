package org.studypro.SpringStarter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studypro.SpringStarter.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
