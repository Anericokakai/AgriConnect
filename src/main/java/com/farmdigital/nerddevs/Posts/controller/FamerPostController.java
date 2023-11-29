package com.farmdigital.nerddevs.Posts.controller;

import com.farmdigital.nerddevs.Posts.Dto.ProductDto;
import com.farmdigital.nerddevs.Posts.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/agri_connect/post")
@RequiredArgsConstructor
public class FamerPostController {
    private final PostService postService;

    @PostMapping("/create_post/{userId}")
    public ResponseEntity<?> createNewPost(@RequestBody ProductDto productDto,@PathVariable("userId")int  userId){
   var res=postService.createPost(productDto,userId);


        return  ResponseEntity.status(200).body(res);

    }

}
