package com.farmdigital.nerddevs.Posts.controller;

import com.farmdigital.nerddevs.Posts.Service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agri_connect/search")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/post_search")

    public ResponseEntity<?> searchPost(@RequestParam("query") String query) {

       var res=  searchService.searchPost(query);


        return ResponseEntity.status(200).body(res);

    }
}
