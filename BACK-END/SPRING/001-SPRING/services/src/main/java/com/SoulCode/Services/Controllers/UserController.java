package com.SoulCode.Services.Controllers;


import com.SoulCode.Services.Models.User;
import com.SoulCode.Services.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("services")
public class UserController {

    @Autowired
    private UserService userService;

    // classe criada para codificar senhas
    @Autowired
    private PasswordEncoder passwordEncoder;

    //CONTROLE DO SERVIÇO 01. READ
    @GetMapping("/user")
    public List<User> showAllUsers(){
        return userService.showAllUsers();
    }

    //CONTROLE DO SERVIÇO 01. CREATE
    @PostMapping("/user")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        user = userService.registerUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
