package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.User;
import com.SoulCode.Services.Repositories.UserRepository;
import com.SoulCode.Services.Security.AuthUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override

    @CachePut(value = "usernameCache", key="#login")
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByLogin(login);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new AuthUserDetail(user.get().getLogin(), user.get().getPassword());
    }
}


// O propósito do UserDetailService é carregar o usuário de alguma fonte de dados e criar uma instância de AuthUserDetail, conhecida pelo Spring