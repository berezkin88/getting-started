package org.acme.getting.started.controllers;

import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import org.acme.getting.started.models.Post;
import org.acme.getting.started.services.PostService;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
class PostControllerTest {

    @InjectMock
    PostServiceBean postService;

    private static final Post post = new Post();

    @Test
    void getAllPosts() {
        given()
            .when()
            .get("/posts")
            .then()
            .statusCode(200);

        verify(postService, times(1)).findAllPosts();
    }

    @Test
    void getPost() {
        when(postService.findPostById(1L)).thenReturn(post);

        given()
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200);

        verify(postService, times(1)).findPostById(1L);
    }

    @Test
    void createPost() {
        given()
            .contentType(ContentType.JSON)
            .body(new Post())
            .when()
            .post("/posts")
            .then()
            .statusCode(200);

        verify(postService, times(1)).creatPost(any(Post.class));
    }

    @Test
    void updatePost() {
        given()
            .contentType(ContentType.JSON)
            .body(new Post())
            .when()
            .put("/posts")
            .then()
            .statusCode(202);

        verify(postService, times(1)).updatePost(any(Post.class));
    }

    @Test
    void deletePost() {
        given()
            .when()
            .delete("/posts/1")
            .then()
            .statusCode(204);

        verify(postService, times(1)).deletePost(1L);
    }

    @Mock
    @ApplicationScoped
    public static class PostServiceBean extends PostService {
    }
}