package org.studypro.SpringBlog.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studypro.SpringBlog.models.Post;
import org.studypro.SpringBlog.repositories.PostRepositoty;

@Service
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
        if(post.getPostId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }
        post.setUpdatedOn(LocalDateTime.now());
        return postRepositoty.save(post);
    }
}
