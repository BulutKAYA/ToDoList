package com.bulut.todolist.repository;

import com.bulut.todolist.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT a FROM User a where a.email = :email and a.password = :password ")
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
