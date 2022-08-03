package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.User;
import com.SoulCode.Services.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // READ. SERVIÇO 01: Mostrar todos os usuários
    @Cacheable("userCache")
    public List<User> showAllUsers(){
        return userRepository.findAll();
    }

    // CREATE. SERVIÇO 02: Cadastrar usuário
    @CachePut(value = "userCache", key = "#user.id")
    public User registerUser(User user){
        return userRepository.save(user);
    }
}
