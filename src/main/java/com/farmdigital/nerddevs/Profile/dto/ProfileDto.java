package com.farmdigital.nerddevs.Profile.dto;

import jakarta.persistence.ElementCollection;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class ProfileDto {
    private List<String > sellingCrops;
    private List<String >  interestedCrops;
    private String  county;
    private String  status;
}
