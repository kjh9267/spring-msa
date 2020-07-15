package me.jun.homeservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    public static final String URL = "http://post-service/post/";

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPostDetailFallback")
    public String getPostDetail(String postId) {
        return restTemplate.getForObject(URL + postId, String.class);
    }

    public String getPostDetailFallback(String postId, Throwable throwable) {
        System.out.println(throwable);
        return "Post server error" + " " + postId;
    }
}
