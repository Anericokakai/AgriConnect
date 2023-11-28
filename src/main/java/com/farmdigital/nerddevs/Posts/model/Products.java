package com.farmdigital.nerddevs.Posts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
