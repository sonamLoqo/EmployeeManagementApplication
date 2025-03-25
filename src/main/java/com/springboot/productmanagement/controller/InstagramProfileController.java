package com.springboot.productmanagement.controller;

import co.elastic.clients.elasticsearch.core.search.Profile;
import com.springboot.productmanagement.entity.InstagramProfile;
import com.springboot.productmanagement.service.InstagramProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class InstagramProfileController {
    @Autowired
    private InstagramProfileService instagramProfileService;

    public InstagramProfileController(InstagramProfileService instagramProfileService) {
        this.instagramProfileService = instagramProfileService;
    }

    @GetMapping("/search/followers_count")
    public List<InstagramProfile>searchByFollowersCount(@RequestParam Long min,@RequestParam Long max){
        return instagramProfileService.fetchProfilesByFollowerCount(min,max);
    }

    @GetMapping("/search/usernames")
    public List<InstagramProfile> searchByUsername(@RequestParam String username){
        return instagramProfileService.fetchProfilesByUsername(username,0,10,"username");
    }

    @GetMapping("/search/category")
    public ResponseEntity<?> searchByCategory(@RequestParam String category) {
        try {
            List<InstagramProfile> profiles = instagramProfileService.fetchProfileByCategory(category);
            return ResponseEntity.ok(profiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving profiles: " + e.getMessage());
        }
    }

    @PostMapping("/save-all")
    public ResponseEntity<String> saveProfiles(@RequestBody List<InstagramProfile> profiles) {
        try {
            instagramProfileService.saveAllProfiles(profiles);
            return ResponseEntity.ok("Profiles saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save profiles: " + e.getMessage());
        }
    }

    @GetMapping("/categories/list")
    public List<String> getAllCategories() {
        return instagramProfileService.fetchAllCategories();
    }
}
