package org.studypro.SpringStarter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.studypro.SpringStarter.models.Post;
import org.studypro.SpringStarter.repositories.PostRepositoty;

public class PostService {
    
    @Autowired
    private PostRepositoty postRepositoty;

    public Optional<Post> getById(Long id) {
        return postRepositoty.findById(id);
    }

    public List<Post> getAll() {
        return postRepositoty.findAll();
    }

    public void delete(Post post) {
        postRepositoty.delete(post);
    }

    public Post save(Post post) {
        if(post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepositoty.save(post);
    }
}
