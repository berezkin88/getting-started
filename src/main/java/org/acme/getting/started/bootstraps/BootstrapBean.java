package org.acme.getting.started.bootstraps;

import io.quarkus.runtime.Startup;
import org.acme.getting.started.models.Post;
import org.acme.getting.started.services.PostService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@Startup
@ApplicationScoped
public class BootstrapBean {

    private final PostService postService;

    public BootstrapBean(PostService postService) {
        this.postService = postService;
        init();
    }

    private void init() {
        Post first = new Post();
        first.setDate(new Date());
        first.setPostTitle("First Post");
        first.setPostContent("The content of the first post");

        Post second = new Post();
        second.setDate(new Date());
        second.setPostTitle("Second Post");
        second.setPostContent("The content of the second post");

        Post third = new Post();
        third.setDate(new Date());
        third.setPostTitle("Third Post");
        third.setPostContent("The content of the third post");

        postService.creatPost(first);
        postService.creatPost(second);
        postService.creatPost(third);
    }
}
