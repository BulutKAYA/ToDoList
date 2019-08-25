package com.bulut.todolist.service;

import com.bulut.todolist.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {
    User saveOrUpdateUser(User user);
    User findUserByEmailAndPassword(String email, String password);
}