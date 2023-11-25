package com.farmdigital.nerddevs.Registration.Repository;

import com.farmdigital.nerddevs.Registration.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
Roles findByName(String  name);


}
