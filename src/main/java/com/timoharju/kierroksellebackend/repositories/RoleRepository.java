package com.timoharju.kierroksellebackend.repositories;

import com.timoharju.kierroksellebackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
