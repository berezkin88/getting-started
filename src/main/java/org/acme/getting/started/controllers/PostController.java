package org.acme.getting.started.controllers;

import org.acme.getting.started.models.Post;
import org.acme.getting.started.services.PostService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/posts")
public class PostController {

    @Inject
    PostService postService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPost(@PathParam("id") Long id) {
        return postService.findPostById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces
    public Response createPost(Post post) {
        postService.creatPost(post);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces
    public Response updatePost(Post post) {
        postService.updatePost(post);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces
    public void deletePost(@PathParam("id") Long id) {
        postService.deletePost(id);
    }
}
