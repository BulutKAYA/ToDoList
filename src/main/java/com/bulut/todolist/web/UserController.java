package com.bulut.todolist.web;

import com.bulut.todolist.model.User;
import com.bulut.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageProvider;


    @PostMapping("")
    public ResponseEntity<?> userRegistration(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        User newUS = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(newUS, HttpStatus.CREATED);
    }

    @GetMapping("")
    public User findUserByEmailAndPassword(String email, String password)
    {
        return userService.findUserByEmailAndPassword(email, password);
    }

    @GetMapping("/login")
    public String doLogin(String email, String password) {

        final String view = "user/login";
        User user = userService.findUserByEmailAndPassword(email, password);

        if (user == null) {
            return view;
        }
        return "redirect:/todolist";
    }

}