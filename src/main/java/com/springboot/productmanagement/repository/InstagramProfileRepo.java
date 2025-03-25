package com.springboot.productmanagement.repository;

import com.springboot.productmanagement.entity.InstagramProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface InstagramProfileRepo extends ElasticsearchRepository<InstagramProfile,String> {


    Page<InstagramProfile> findByUsername(String username, Pageable pageable);


    Page<InstagramProfile> findByCategory(String category, Pageable pageable);


    List<InstagramProfile> findByFollowerCountBetween(Long min, Long max);

    @Query("SELECT DISTINCT p.category FROM InstagramProfile p")
    List<String> findAllCategories();
}