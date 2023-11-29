package com.farmdigital.nerddevs.Posts.repository;

import com.farmdigital.nerddevs.Posts.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Integer>  {
    @Query(value = "SELECT id, product_tittle, product_price, image_url, quantity, product_location, product_description, post_time, likes, pick_up_station, product_status  FROM posts WHERE profile_id=?",nativeQuery = true)
    List<Products> findByProfileId(Integer integer);
}
