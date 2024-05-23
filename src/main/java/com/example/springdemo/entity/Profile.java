package com.example.springdemo.entity;

import com.example.springdemo.enums.Roles;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profiles")
public class Profile extends BasicEntity{
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();
    @Column(name = "name_")
    private String name;
    @Column(name = "surname_")
    private String surname;
    @Column(name = "phone_number_")
    private String phoneNumber;
    @Column(name = "role_")
    @Enumerated
    private Roles role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_", referencedColumnName = "id_")
    private ProfileInfo info;

}
