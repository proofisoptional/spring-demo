package com.example.springdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dictionary")
public class Dictionary extends BasicEntity{
    @Id
    @Column(name = "id_")
    private UUID id;
    @Column(name = "key_")
    private String key;
    @Column(name = "name_")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dictionary", orphanRemoval = true)
    private List<DictionaryItem> items;
}
