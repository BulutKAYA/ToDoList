package com.bulut.todolist.web;

import com.bulut.todolist.model.User;
import com.bulut.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//        model.addAttribute("role", "");
        //model.addAttribute("registrationRequest", new RegistrationRequest());

        //String[] tmp = new String[] {"student", "teacher"};

        return "registration";
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User userEntity = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(userEntity, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long noteId) {
        return userService.findByUserId(noteId);
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}