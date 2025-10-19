package com.demo.demo.repository;

import com.demo.demo.entities.Role;
import com.demo.demo.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Long> {
    Optional<Role> findByRolename(RoleName rolename);
}
