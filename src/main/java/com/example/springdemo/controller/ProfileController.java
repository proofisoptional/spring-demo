package com.example.springdemo.controller;


import com.example.springdemo.dto.Profile.ProfileDto;
import com.example.springdemo.entity.Profile;
import com.example.springdemo.service.ProfileService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;



    @PreAuthorize("hasRole('admin')")
    @PostMapping("/save")
    public ResponseEntity<Profile> saveProfile(@RequestBody ProfileDto dto) {
        Profile profile = profileService.saveProfile(dto);
        return ResponseEntity.ok(profile);
    }
}
