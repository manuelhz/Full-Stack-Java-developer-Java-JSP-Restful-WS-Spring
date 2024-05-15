package org.studypro.SpringBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studypro.SpringBlog.models.Post;

@Repository
public interface PostRepositoty extends JpaRepository<Post, Long> {
    
}