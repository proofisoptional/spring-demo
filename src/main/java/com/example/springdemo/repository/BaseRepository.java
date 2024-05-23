package com.example.springdemo.repository;

import com.example.springdemo.entity.BasicEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BasicEntity, ID extends Serializable> extends JpaRepository<T, ID> {
    void delete(T entity);
}
