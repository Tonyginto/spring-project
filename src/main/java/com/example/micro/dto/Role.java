package com.example.micro.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long roleId;

  private String roleName;

  public Long getRoleId() {
    return roleId;
  }

  public String getRoleName() {
    return roleName;
  }
}
