package com.example.springdemo.mapper;

import com.example.springdemo.controller.ProfileController;
import com.example.springdemo.dto.Profile.ProfileDto;
import com.example.springdemo.entity.Profile;
import com.example.springdemo.enums.Roles;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring", uses = ProfileController.class)
public interface ProfileMapper {
    @Mapping(target = "role", source = "role", qualifiedByName = "mapRoleEnum")
    Profile mapProfileDtoToEntity(ProfileDto profileDto);

    ProfileDto mapEntityToDto(Profile profile);

    @Named("mapRoleEnum")
    static Roles mapRoleFromString(String role) {
        var s = Roles.getRoleByValue(role);
        return s;
    }
}
