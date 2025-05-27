package com.basico.gonzalo.basicogonzalo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profiles")
public class UserProfile {

    @Id
    @GeneratedValue
    @Column(name= "id",nullable = false, unique = true)
    private UUID id; 

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "descripcion")
    private String descripcion;

    
    
}
