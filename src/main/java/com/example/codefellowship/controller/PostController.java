package com.example.codefellowship.controller;

import com.example.codefellowship.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post/{user_id}")
    public String getPosts(@PathVariable("user_id") Integer id) {
        postService.getAllPost(id);
        return "users.html";
    }

    @PostMapping("/post")
    public RedirectView createPost(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content, @RequestParam(value = "imageFilePath") String imageFilePath) {
        postService.addPost(title, content, imageFilePath);
        return new RedirectView("/post");
    }
}
