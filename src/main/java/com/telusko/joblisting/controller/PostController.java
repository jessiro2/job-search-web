package com.telusko.joblisting.controller;

import com.telusko.joblisting.repository.PostRepository;
import com.telusko.joblisting.model.Post;
import com.telusko.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    //autowire annotation creates an object for you and maps it
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

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

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

     @PostMapping("/post")
     public Post addPost(@RequestBody Post post) {
            return repo.save(post);
     }


}
