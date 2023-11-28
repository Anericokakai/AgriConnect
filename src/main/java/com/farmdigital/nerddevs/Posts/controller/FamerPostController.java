package com.farmdigital.nerddevs.Posts.controller;

import com.farmdigital.nerddevs.Posts.Dto.ProductDto;
import com.farmdigital.nerddevs.Posts.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/agri_connect/post")
@RequiredArgsConstructor
public class FamerPostController {
    private final PostService postService;

    @PostMapping("/create_post")
    public ResponseEntity<?> createNewPost(@RequestBody ProductDto productDto){
        postService.createPost(productDto);


        return null;

    }

}
