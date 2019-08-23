package com.bulut.todolist.service;
import com.bulut.todolist.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User saveOrUpdateUser(User user);

    User findByUserId(Long userId);
}