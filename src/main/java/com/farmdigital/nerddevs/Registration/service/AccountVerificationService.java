package com.farmdigital.nerddevs.Registration.service;

import com.farmdigital.nerddevs.Registration.Exceptions.InvalidAuthenticationException;
import com.farmdigital.nerddevs.Registration.model.Farmer;
import com.farmdigital.nerddevs.Registration.Repository.FarmerRepository;
import com.farmdigital.nerddevs.Registration.security.JwtServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountVerificationService {
    private final JwtServices jwtServices;
    private  final FarmerRepository farmerRepository;

public String  verifyUserAccount(String  token) throws InvalidAuthenticationException{
//    ! extract the email from the token
    String  email= jwtServices.extractUsername(token);
    boolean  isAValidUser= jwtServices.CheckTokenExpiryForAccountVerification(token,email);
//    ! update the user status to be verified
    Farmer userToUpdate= farmerRepository.findByEmail(email).get();
    userToUpdate.setVerified(true);
    farmerRepository.save(userToUpdate);
    return " user account verification successful";
}
}
