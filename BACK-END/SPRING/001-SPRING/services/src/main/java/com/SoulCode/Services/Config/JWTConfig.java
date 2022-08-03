package com.SoulCode.Services.Config;

import com.SoulCode.Services.Security.JWTAuthenticationFilter;
import com.SoulCode.Services.Security.JWTAuthorizationFilter;
import com.SoulCode.Services.Services.AuthUserDetailService;
import com.SoulCode.Services.Util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

//bean para configurar o security
@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthUserDetailService userDetailService;

    //UserDetailService -> carregar o usuário do banco
    // BCrypt -> gerador de hash de senhas
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cors -- cross origin é habilitado e o csrf é desabilitado
        // csrf é uma configuração que pode ser desabilitada
        http.cors().and().csrf().disable();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtils));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtils));



        http.authorizeRequests()
                // autorizar a requisição a partir do end point /login
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                //.antMatchers(HttpMethod.GET,"/services/**").permitAll()
         .anyRequest().authenticated();

        // criação de politica de autenticação. STATELESS informa que não iremos criar
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // bean necessária para comunicação com o front-end, permite não dar erro de cors
    // CROSS ORIGIN RESOURCE SHARING.
    @Bean
    // CROSS ORIGIN RESOURCE SHARING
    // necessário configurar para que não haja bloqueio por causa de rota
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration(); // configurações de cors padrão
        configuration.setAllowedMethods(List.of( // lista que informa quais são os métodos liberados via CORS
                HttpMethod.GET.name(),
                HttpMethod.PUT.name(),
                HttpMethod.POST.name(),
                HttpMethod.GET.name()

        )); // metodos permitidos para o front acessar
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // objeto que irá permitir quais portas poderão ser aceitas
        source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
         // ** informa que vale qualquer endpoint.
        // Ex: "/services/employees" é igual a "/**"
        // no caso da função, informa os endpoints permitidos para o front acessar
        return source;
    }

    // Injeção a nível de método (os outros, geralmente, são injetados como classe)
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


}
