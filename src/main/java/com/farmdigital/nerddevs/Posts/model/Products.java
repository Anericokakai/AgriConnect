package com.farmdigital.nerddevs.Posts.model;

import com.farmdigital.nerddevs.Profile.model.Profile;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@Getter
@Setter
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productTittle;
    private int productPrice;
    private  String  imageUrl;
    private String  quantity;
    private String  productLocation;
    private String productDescription;
    private String  postTime;
    private int likes=0;
    private String  pickUpStation;
    private String productStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private  Profile profile;

}
