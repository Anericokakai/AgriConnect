package com.farmdigital.nerddevs.Posts.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String productTittle;
    private int productPrice;
    private  String  imageUrl;
    private String  quantity;
    private String  productLocation;
    private String productDescription;
    private String  pickUpStation;


}
