package com.ust.Authentication_service.controller;

import com.ust.Authentication_service.model.User;
import com.ust.Authentication_service.service.JwtService;
import com.ust.Authentication_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/validate/token")
    public boolean validateToken(@RequestParam String token){
        return jwtService.validateToken(token);
    }


    @PostMapping("/validate/user")
    public String getToken(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "Forbidden";
    }

}
