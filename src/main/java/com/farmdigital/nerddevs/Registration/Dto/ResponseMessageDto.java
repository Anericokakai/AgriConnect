package com.farmdigital.nerddevs.Registration.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NonNull
@Builder
public class ResponseMessageDto {

    public  String message;

}