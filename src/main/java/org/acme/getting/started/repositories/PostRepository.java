package org.acme.getting.started.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.acme.getting.started.models.Post;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

    public void creatPost(Post post) {
        persist(post);
    }

    public List<Post> findAllPosts() {
        return listAll();
    }

    public Post findPostById(Long id) {
        return findById(id);
    }

    public void updatePost(Parameters params) {
        update("update from posts set date =?1 and set postTitle = ?2 and set postContent = ?3 where id = ?4", params);
    }

    public void deletePost(Long id) {
        deleteById(id);
    }
}
