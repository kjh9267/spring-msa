package me.jun.homeservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPostDetailFallback")
    public String getPostDetail(String postId) {
        return restTemplate.getForObject("http://localhost:8082/post/" + postId, String.class);
    }

    public String getPostDetailFallback(String postId) {
        return "Post server error" + " " + postId;
    }
}
