package org.acme.getting.started.repositories;

import io.quarkus.panache.common.Parameters;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.getting.started.models.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@QuarkusTest
class PostRepositoryTest {

    @InjectMock
    PostRepository postRepository;

    private final Post post = new Post();

    @Test
    void creatPost() {
        doCallRealMethod().when(postRepository).creatPost(post);
        postRepository.creatPost(post);

        verify(postRepository, times(1)).persist(post);
    }

    @Test
    void findAllPosts() {
        doCallRealMethod().when(postRepository).findAllPosts();
        when(postRepository.listAll()).thenReturn(List.of(post));

        List<Post> actualPosts = postRepository.findAllPosts();

        verify(postRepository, times(1)).listAll();

        assertEquals(1, actualPosts.size());
        assertEquals(post, actualPosts.get(0));
    }

    @Test
    void findPostById() {
        doCallRealMethod().when(postRepository).findPostById(1L);
        when(postRepository.findById(1L)).thenReturn(post);

        Post actualPost = postRepository.findPostById(1L);

        verify(postRepository, times(1)).findById(1L);

        assertNotNull(actualPost);
        assertEquals(post, actualPost);
    }

    @Test
    void updatePost() {
        doCallRealMethod().when(postRepository).updatePost(any());

        postRepository.updatePost(new Parameters());

        verify(postRepository, times(1)).update(anyString(), any(Parameters.class));
    }

    @Test
    void deletePost() {
        doCallRealMethod().when(postRepository).deletePost(1L);

        postRepository.deletePost(1L);

        verify(postRepository, times(1)).deleteById(1L);
    }
}