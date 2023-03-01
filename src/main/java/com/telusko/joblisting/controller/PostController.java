package com.telusko.joblisting.controller;

import com.telusko.joblisting.PostRepository;
import com.telusko.joblisting.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    //autowire annotation creates an object for you and maps it
    @Autowired
    PostRepository repo;

    // create a method to enable the swagger
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    //fetch all the posts
    @GetMapping("/posts")
     public List<Post> getAllPosts() {
        return repo.findAll();
     }

     @PostMapping("/post")
     public Post addPost(@RequestBody Post post) {
            return repo.save(post);
     }
}
