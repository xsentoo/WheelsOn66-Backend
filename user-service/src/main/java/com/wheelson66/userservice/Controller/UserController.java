package com.wheelson66.userservice.Controller;

import com.wheelson66.userservice.Dto.RegisterRequest;
import com.wheelson66.userservice.Entity.User;
import com.wheelson66.userservice.Repository.UserRepository;
import com.wheelson66.userservice.Service.JwtService;
import com.wheelson66.userservice.Service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final  UserService userService;
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public User CreateUser(@RequestBody RegisterRequest request){
        return userService.registerUser(request.getEmail(), request.getRawPassword(), request.getPseudo());
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterRequest request){
        return userService.loginUser(request.getEmail(), request.getRawPassword());
    }


}
