package com.bulut.todolist.repository;

import com.bulut.todolist.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserId(Long userId);
}
