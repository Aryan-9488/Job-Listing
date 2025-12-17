package com.aryan.joblisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.joblisting.model.Post;
import com.aryan.joblisting.repository.PostRepository;
import com.aryan.joblisting.repository.SearchRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;
    
    @Autowired
    SearchRepository srepo;

    // Redirect root URL to Swagger UI
    @Hidden
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/allPosts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }
    
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
    	return srepo.findByText(text);
    }
    
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
    	return repo.save(post);
    }
}
