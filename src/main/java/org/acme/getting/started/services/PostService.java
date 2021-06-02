package org.acme.getting.started.services;

import io.quarkus.panache.common.Parameters;
import org.acme.getting.started.models.Post;
import org.acme.getting.started.repositories.PostRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository repository;

    @Transactional
    public void creatPost(Post post) {
        repository.creatPost(post);
    }

    public List<Post> findAllPosts() {
        return repository.findAllPosts();
    }

    public Post findPostById(Long id) {
        return repository.findPostById(id);
    }

    @Transactional
    public void updatePost(Post post) {
        Parameters params = Parameters.with("date", post.getDate())
            .and("postTitle", post.getPostTitle())
            .and("postContent", post.getPostContent())
            .and("id", post.getId());
        System.out.println(post);
        repository.updatePost(params);
    }

    public void deletePost(Long id) {
        repository.deletePost(id);
    }
}
