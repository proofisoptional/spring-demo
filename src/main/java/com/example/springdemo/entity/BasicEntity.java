package com.example.springdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

public abstract class BasicEntity {
    @Column(name = "created_date_")
    private LocalDate createdDate;
    @Column(name = "modified_date_")
    private LocalDate modifiedDate;

}
