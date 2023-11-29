package com.farmdigital.nerddevs.Profile.model;

import com.farmdigital.nerddevs.Posts.model.Products;
import com.farmdigital.nerddevs.Registration.model.Farmer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "farmer_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ElementCollection
    private List<String >  sellingCrops;
    @ElementCollection
    private List<String >  interestedCrops;
    private  int ratings;
    private String  county;
    @Column(name = "active_status")
    private boolean  active=false;
    private String   lastSeen;
    private String  updatedAt;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "profile",fetch = FetchType.LAZY)
    private List<Products> products;

}
