package com.springboot.productmanagement.service;

import com.springboot.productmanagement.entity.InstagramProfile;
import com.springboot.productmanagement.repository.InstagramProfileRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class InstagramProfileService {


    @Autowired
    private InstagramProfileRepo repo;

    public InstagramProfileService(InstagramProfileRepo repo) {
        this.repo = repo;
    }

    public List<InstagramProfile> fetchProfilesByFollowerCount(Long min, Long max) {
        return repo.findByFollowerCountBetween(min, max);
    }
    public List<InstagramProfile> fetchProfilesByUsername(String username, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return repo.findByUsername(username, pageable).getContent();
    }

    public List<InstagramProfile> fetchProfileByCategory(String category) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("category"));
        return repo.findByCategory(category, pageable).getContent();
    }

    public void saveAllProfiles(List<InstagramProfile> profiles) {
        repo.saveAll(profiles);
    }

    public List<String> fetchAllCategories() {
        try {
            // Convert Iterable to List
            List<InstagramProfile> profiles = new ArrayList<>();
            repo.findAll().forEach(profiles::add);

            if (profiles.isEmpty()) {
                return Collections.emptyList();
            }

            List<String> categories = profiles.stream()
                    .map(InstagramProfile::getCategory)
                    .filter(category -> category != null && !category.isEmpty())
                    .distinct()
                    .collect(Collectors.toList());

            return categories.isEmpty() ? Collections.emptyList() : categories;
        } catch (Exception e) {
            log.error("Error fetching categories", e);
            return Collections.emptyList();
        }

    }
}
