package com.example.springdemo.controller;


import com.example.springdemo.dto.Profile.ProfileDto;
import com.example.springdemo.entity.Profile;
import com.example.springdemo.service.ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;



    @Tag(name = "Profile", description = "Create new profile")
    @PreAuthorize("hasRole('admin')")
    @PostMapping("/save")
    public ResponseEntity<Profile> saveProfile(@RequestBody ProfileDto dto) {
        Profile profile = profileService.saveProfile(dto);
        return ResponseEntity.ok(profile);
    }
}
