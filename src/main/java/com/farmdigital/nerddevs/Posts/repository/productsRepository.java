package com.farmdigital.nerddevs.Posts.repository;

import com.farmdigital.nerddevs.Posts.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productsRepository extends JpaRepository<Products,Integer>  {
}
