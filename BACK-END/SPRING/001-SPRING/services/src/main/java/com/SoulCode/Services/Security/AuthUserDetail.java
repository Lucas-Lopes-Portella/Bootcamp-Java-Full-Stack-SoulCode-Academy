package com.SoulCode.Services.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthUserDetail implements UserDetails {

    private String login;
    private String password;

    public AuthUserDetail(String login, String password){
        this.login = login;
        this.password = password;
    }

    // coleção de papeis do usuário,
    // como não implementamos, retornar algo vazio
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // true permite o usuario logar
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } // conta não bloqueada

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //true informa que todos os usuários estão habilitados
        return true;
    }
}
// O Spring Security não se comunica diretamente o o nosso model User.
// Nesse caso é necessário criar uma classe que ele conheça para fazer essa comunicação,
// UserDetails = Guarda informações do contexto de autenticação do usuário (autorização, habilitado, etc...)