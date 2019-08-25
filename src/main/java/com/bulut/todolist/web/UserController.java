package com.bulut.todolist.web;

import com.bulut.todolist.form.LoginForm;
import com.bulut.todolist.model.User;
import com.bulut.todolist.service.UserService;
import com.bulut.todolist.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageProvider;

    @Autowired
    private SessionData sessionData;


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

    @GetMapping(value = "/login")
    public String doLogin(String email, String password, BindingResult bindingResult) {

        final String view = "user/login";
        User user = userService.findUserByEmailAndPassword(email, password);

        if (bindingResult.hasErrors()) {
            return view;
        }
        if (user == null) {
            return view;
        }
        sessionData.setUser(user);
        sessionData.setLocale(Locale.ENGLISH);
        return view;
    }

}