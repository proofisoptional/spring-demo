package com.example.springdemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "infos")
public class ProfileInfo extends BasicEntity{
    @Id
    @Column(name = "id_")
    private UUID id;
    @Column(name = "city_")
    private UUID cityId;
    @Column(name = "country_")
    private UUID country;
    @Column(name= "street_")
    private String street;
    @Column(name = "email_")
    private String email;
    @Column(name = "telegram_")
    private String telegram;
    @OneToOne(mappedBy = "info")
    private Profile profile;
}
