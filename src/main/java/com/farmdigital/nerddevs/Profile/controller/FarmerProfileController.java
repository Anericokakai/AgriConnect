package com.farmdigital.nerddevs.Profile.controller;

import com.farmdigital.nerddevs.Profile.dto.ProfileDto;
import com.farmdigital.nerddevs.Profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agri_connect/profile")
public class FarmerProfileController {

private  final ProfileService profileService;

    @PostMapping("/add_Profile/{userId}")

    public ResponseEntity<?> addnewProfile(@RequestBody ProfileDto profileDto, @PathVariable("userId") String  userId){

        var res= profileService.saveProfile(profileDto,userId);
        URI uri= URI.create("/profile");
        return ResponseEntity.created(uri ).body(res);



    }
}
