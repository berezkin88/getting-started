package org.acme.getting.started.controllers;

import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.getting.started.models.Post;
import org.acme.getting.started.services.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.enterprise.context.ApplicationScoped;

import static io.restassured.RestAssured.given;

@QuarkusTest
class PostControllerTest {

    @InjectMock
    PostServiceBean postService;

    private static final Post post = new Post();

    @Test
    void getAllPosts() {
        given()
            .when().get("/posts")
            .then()
            .statusCode(200);

        Mockito.verify(postService, Mockito.times(1)).findAllPosts();
    }

    @Test
    void getPost() {
        given()
            .when().get("/posts/1")
            .then()
            .statusCode(204);

        Mockito.verify(postService, Mockito.times(1)).findPostById(1L);
    }

    @Test
    void createPost() {
        // research
        given()
            .when().post("/posts")
            .then()
            .statusCode(200);

        Mockito.verify(postService, Mockito.times(1)).creatPost(null);
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }

    @Mock
    @ApplicationScoped
    public static class PostServiceBean extends PostService {
        @Override
        public Post findPostById(Long id) {
            return post;
        }
    }
}