package org.acme.getting.started.services;

import io.quarkus.test.junit.QuarkusTestExtension;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.getting.started.models.Post;
import org.acme.getting.started.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(QuarkusTestExtension.class)
class PostServiceTest {

    @Inject
    PostService postService;
    @InjectMock
    PostRepository postRepository;

    @Test
    void creatPost() {
        postService.creatPost(new Post());

        verify(postRepository, times(1)).creatPost(any(Post.class));
    }

    @Test
    void findAllPosts() {
        when(postRepository.findAllPosts()).thenReturn(List.of(new Post()));

        List<Post> actualPosts = postService.findAllPosts();

        verify(postRepository, times(1)).findAllPosts();

        assertNotNull(actualPosts);
        assertEquals(1, actualPosts.size());
    }

    @Test
    void findPostById() {
        Post post = new Post();
        final long id = 1L;

        post.setId(id);

        when(postRepository.findPostById(id)).thenReturn(post);

        Post actualPost = postService.findPostById(id);

        verify(postRepository, times(1)).findPostById(id);

        assertNotNull(actualPost);
        assertEquals(post, actualPost);
    }

    @Test
    void updatePost() {
        postService.updatePost(new Post());

        verify(postRepository, times(1)).updatePost(any());
    }

    @Test
    void deletePost() {
        postService.deletePost(1L);

        verify(postRepository, times(1)).deletePost(anyLong());
    }
}