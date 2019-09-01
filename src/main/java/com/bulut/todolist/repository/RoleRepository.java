package com.bulut.todolist.repository;

import com.bulut.todolist.model.Role;
import com.bulut.todolist.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
