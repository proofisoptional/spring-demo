package com.example.springdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dictionary_items")
public class DictionaryItem extends BasicEntity{
    @Id
    @Column(name = "id_")
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dictionary_", nullable = false)
    private Dictionary dictionary;
    @Column(name = "name_")
    private String name;
}
