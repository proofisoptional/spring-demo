package com.example.springdemo.service;


import com.example.springdemo.dto.Profile.ProfileDto;
import com.example.springdemo.entity.Profile;
import com.example.springdemo.mapper.ProfileMapper;
import com.example.springdemo.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final KeycloakService keycloakService;
    private final ProfileMapper profileMapper;

    public Profile saveProfile(ProfileDto profileDto){
        Profile profile = profileMapper.mapProfileDtoToEntity(profileDto);
        keycloakService.addUser(profileDto);
        profileRepository.save(profile);
        return profile;
    }
}
