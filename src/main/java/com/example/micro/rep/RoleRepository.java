package com.example.micro.rep;

import com.example.micro.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    String getRoleByRoleId(Long roleId);
}
