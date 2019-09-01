package com.bulut.todolist.security;

import com.bulut.todolist.model.Role;
import com.bulut.todolist.model.RoleName;
import com.bulut.todolist.model.User;
import com.bulut.todolist.repository.RoleRepository;
import com.bulut.todolist.service.UserService;
import com.bulut.todolist.service.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class JwtValidator {

    @Autowired
    RoleRepository roleRepository;

    UserService userService;

    public JwtValidator(){
        this.userService = new UserServiceImpl();
    }

    public User validate(String token) {
        User user = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            user = userService.findUserByEmailAndPassword((String) body.get("email"), body.getSubject());
            Set<Role> roles = new HashSet<>();
            Role role;
            switch((String) body.get("role")) {
                case "admin":
                    role = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

                    break;
                case "pm":
                    role = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

                    break;
                default:
                    role = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            }
            roles.add(role);
            user.setRoles(roles);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }
}
