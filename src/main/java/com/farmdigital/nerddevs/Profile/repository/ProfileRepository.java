package com.farmdigital.nerddevs.Profile.repository;

import com.farmdigital.nerddevs.Profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<Profile,Integer> {
}
