package com.example.micro.rep;

import com.example.micro.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role getByRoleId(Long roleId);
}
