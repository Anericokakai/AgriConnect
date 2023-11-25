package com.farmdigital.nerddevs.Registration.Repository;

import com.farmdigital.nerddevs.Registration.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

  Optional<Farmer> findByEmail(String  email);
  Optional<Farmer> findByName(String name);

}
