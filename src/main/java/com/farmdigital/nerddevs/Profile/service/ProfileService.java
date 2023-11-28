package com.farmdigital.nerddevs.Profile.service;

import com.farmdigital.nerddevs.Profile.dto.ProfileDto;
import com.farmdigital.nerddevs.Profile.model.Profile;
import com.farmdigital.nerddevs.Profile.repository.ProfileRepository;
import com.farmdigital.nerddevs.Registration.Repository.FarmerRepository;
import com.farmdigital.nerddevs.Registration.model.Farmer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final FarmerRepository farmerRepository;
    public Object saveProfile(ProfileDto profileDto, String userId) {
        List<String> sellingCrops = profileDto.getSellingCrops();
        List<String> interestedCrops = profileDto.getInterestedCrops();
//        ! find user from the db
        Farmer farmer = farmerRepository.findByFarmerId(userId).orElseThrow(() -> new EntityNotFoundException("invalid user "));
        if (farmer.getProfile() != null) {
            var updateProfile = Profile.builder()
                    .id(farmer.getProfile().getId())
                    .interestedCrops(Objects.nonNull(profileDto.getInterestedCrops())
                            ? profileDto.getInterestedCrops() : Collections.singletonList(""))
                    .updatedAt(timeCreatedAccout())
                    .active(true)
                    .county(Objects.nonNull(profileDto.getCounty()) ? profileDto.getCounty() : "")
                    .sellingCrops(Objects.nonNull(profileDto.getSellingCrops()) ? profileDto.getSellingCrops() : Collections.singletonList(""))
                    .build();
            farmer.setProfile(updateProfile);
            Map<String, Object> response = new HashMap<>();
            var savedFarmer = farmerRepository.save(farmer);
            response.put("message", "your profile has been updated successfully");
            response.put("profile", savedFarmer.getProfile());
            return response;
        }
        var userProfile = Profile.builder()
                .interestedCrops(interestedCrops)
                .sellingCrops(sellingCrops)
                .county(Objects.nonNull(profileDto.getCounty()) ? profileDto.getCounty() : "")
                .updatedAt(timeCreatedAccout())
                .active(true)
                .build();
        Profile farmerProfile = profileRepository.save(userProfile);
        farmer.setProfile(farmerProfile);
        var savedFarmer = farmerRepository.save(farmer);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "your profile has been created  successfully");
        response.put("profile", savedFarmer.getProfile());
        return response;
    }
    public String timeCreatedAccout() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy 'at' hh:mm a");
        return formatter.format(LocalDateTime.now());
    }
}
