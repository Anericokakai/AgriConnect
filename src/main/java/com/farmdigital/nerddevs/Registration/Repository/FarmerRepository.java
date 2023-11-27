package com.farmdigital.nerddevs.Registration.Repository;

import com.farmdigital.nerddevs.Registration.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

  Optional<Farmer> findByEmail(String  email);
  Optional<Farmer> findByName(String name);

  @Query(value = " SELECT * FROM farmers_registration WHERE farmer_id=?",nativeQuery = true)
  Optional<Farmer> findByFarmerId(String farmerId);

}
