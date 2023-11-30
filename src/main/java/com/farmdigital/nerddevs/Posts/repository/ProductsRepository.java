package com.farmdigital.nerddevs.Posts.repository;

import com.farmdigital.nerddevs.Posts.Dto.FetchProductDto;
import com.farmdigital.nerddevs.Posts.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Integer>  {
    @Query(value = "SELECT *  FROM posts WHERE profile_id=?",nativeQuery = true)
    List<Products> findByProfileId(Integer integer);
}
