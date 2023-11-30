package com.farmdigital.nerddevs.Posts.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FetchProductDto {

    private int id;
    private String productTittle;
    private int productPrice;
    private  String  imageUrl;
    private String  quantity;
    private String  productLocation;
    private String productDescription;
    private String  postTime;
    private int likes;
    private String  pickUpStation;
    private String productStatus;
}
