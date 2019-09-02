package com.bulut.todolist.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.bulut.todolist.model.Role;
import com.bulut.todolist.model.RoleName;
import com.bulut.todolist.model.User;
import com.bulut.todolist.repository.RoleRepository;
import com.bulut.todolist.security.JwtGenerator;
import com.bulut.todolist.security.JwtValidator;
import com.bulut.todolist.security.SecurityConstants;
import com.bulut.todolist.service.UserService;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    private JwtGenerator jwtGenerator;
    private JwtValidator jwtValidator;
    public AuthRestAPIs(){
        this.jwtGenerator = new JwtGenerator();
        this.jwtValidator = new JwtValidator();
    }
    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
        user = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if(user == null){
            return new ResponseEntity<>("Fail -> Can not find user!",
                    HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(this.jwtGenerator.generate(user), HttpStatus.OK);
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User userForm) {
        if(userService.existsByUsername(userForm.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userService.existsByEmail(userForm.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(userForm.getDisplayName(), userForm.getUsername(),
                userForm.getEmail(), userForm.getPassword());

        Set<Role> strRoles = userForm.getRoles();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch(role.getName().name()) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "pm":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userService.saveOrUpdateUser(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }

    @GetMapping("/getuser")
    public User getCurrentUser(String token) {
        return jwtValidator.validate(token);
    }
}