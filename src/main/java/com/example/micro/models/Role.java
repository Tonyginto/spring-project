package com.example.micro.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;

    private String role_name;

    public Long getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }
}
