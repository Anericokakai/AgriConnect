package com.farmdigital.nerddevs.Posts.Service;

import com.farmdigital.nerddevs.Posts.Dto.FetchProductDto;
import com.farmdigital.nerddevs.Posts.Dto.ProductDto;
import com.farmdigital.nerddevs.Posts.model.Products;
import com.farmdigital.nerddevs.Posts.repository.ProductsRepository;
import com.farmdigital.nerddevs.Profile.model.Profile;
import com.farmdigital.nerddevs.Profile.repository.ProfileRepository;
import com.farmdigital.nerddevs.Registration.Repository.FarmerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private  final ProfileRepository profileRepository;
    private  final ProductsRepository productsRepository;
    public static final Logger LOGGER= LoggerFactory.getLogger(Products.class);
    public Object createPost(ProductDto productDto,int profileId) {

        Profile farmerProfile=profileRepository.findById(profileId).orElseThrow(()-> new EntityNotFoundException("Invalid profile id"));
//      ! create a new product post based on the profile id of the user;
        Products products= Products.builder()
                .postTime(timeCreatedAccout())
                .profile(farmerProfile)
                .productLocation(productDto.getProductLocation())
                .productPrice(productDto.getProductPrice())
                .productStatus("ACTIVE")
                .productTittle(productDto.getProductTittle())
                .imageUrl(productDto.getImageUrl())
                .quantity(productDto.getQuantity())
                .productDescription(productDto.getProductDescription())
                .pickUpStation(productDto.getPickUpStation()).build();
         productsRepository.save(products);
         List<Products> allUserProducts=productsRepository.findByProfileId(farmerProfile.getId());
List<FetchProductDto> response= new ArrayList<>();
         for(Products posts:allUserProducts){
             FetchProductDto fetchedUserProduct= FetchProductDto.builder()
                     .id(posts.getId())
                     .imageUrl(posts.getImageUrl())
                     .likes(posts.getLikes())
                     .pickUpStation(posts.getPickUpStation())
                     .postTime(posts.getPostTime())
                     .productDescription(posts.getProductDescription())
                     .productLocation(posts.getProductLocation())
                     .productPrice(posts.getProductPrice())
                     .productStatus(posts.getProductStatus())
                     .productTittle(posts.getProductTittle())
                     .quantity(posts.getQuantity())
                     .build();

            response.add(fetchedUserProduct);

         }

         return response;

    }
    public String timeCreatedAccout() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy 'at' hh:mm a");
        return formatter.format(LocalDateTime.now());
    }
}
