package me.jun.homeservice.controller;

import me.jun.homeservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PostService postService;

    @GetMapping(path = "post/{postId}")
    public String getPost(@PathVariable String postId) {
        return postService.getPostDetail(postId);
    }
}
