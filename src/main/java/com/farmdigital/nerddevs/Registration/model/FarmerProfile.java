package com.farmdigital.nerddevs.Registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class FarmerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String farmerName;
    private String county;
    private String farmsize;
    private String products;
    private LocalDateTime lastseen;




}
