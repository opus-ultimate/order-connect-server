package com.opusultimate.orderconnect.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    private UUID id;

    @Column(nullable = false, length = 50)
    private String displayName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = true)
    private Long phone;

}
