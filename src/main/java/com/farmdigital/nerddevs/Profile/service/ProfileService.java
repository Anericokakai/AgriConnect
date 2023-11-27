package com.farmdigital.nerddevs.Profile.service;

import com.farmdigital.nerddevs.Profile.dto.ProfileDto;
import com.farmdigital.nerddevs.Profile.model.Profile;
import com.farmdigital.nerddevs.Profile.repository.ProfileRepository;
import com.farmdigital.nerddevs.Registration.Repository.FarmerRepository;
import com.farmdigital.nerddevs.Registration.model.Farmer;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.sql.DataTruncation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Log4j2
public class ProfileService {
    private  final ProfileRepository profileRepository;
    private  final FarmerRepository farmerRepository;
    public Object saveProfile(ProfileDto profileDto,String userId) {
        List<String >  sellingCrops=profileDto.getSellingCrops();
        List<String> intrestedCrops=profileDto.getInterestedCrops();
        System.out.println(sellingCrops);
        System.out.println(userId);
//        ! find user from the db
Farmer farmer= farmerRepository.findByFarmerId(userId).orElseThrow(()->new EntityNotFoundException("invalid user "));
        var userProfile= Profile.builder()
                .interestedCrops(intrestedCrops)
                .sellingCrops(sellingCrops)
                .county(Objects.nonNull(profileDto.getCounty())? profileDto.getCounty() : "")
                .updatedAt(timeCreatedAccout())
                .active(true)
                .build();
       Profile farmerProfile= profileRepository.save(userProfile);
        farmer.setProfile(farmerProfile);
        farmerRepository.save(farmer);
////
//        farmer.setProfile(userProfile);
//        profileRepository.save(userProfile);
//        return farmerRepository.save(farmer);

       System.out.println(farmer.toString());

return  userProfile;


    }
    public String  timeCreatedAccout() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy 'at' hh:mm a");
        return formatter.format(LocalDateTime.now());
    }
}
