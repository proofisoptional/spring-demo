package com.example.springdemo.repository;

import com.example.springdemo.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends BaseRepository<Profile, UUID> {

    List<Profile> findAll();

    Optional<Profile> getProfileById(UUID id);
}
