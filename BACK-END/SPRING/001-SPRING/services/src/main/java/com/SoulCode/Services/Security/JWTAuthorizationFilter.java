package com.SoulCode.Services.Security;

import com.SoulCode.Services.Util.JWTUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// verificar se há token
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private JWTUtils jwtUtils;
    public JWTAuthorizationFilter(AuthenticationManager manager, JWTUtils jwtUtils){
        super(manager);
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization"); // Bearer --> padrão de comunicação web que vai concatenado com o token
        if(token!=null && token.startsWith("Bearer")) { //token válido
            // concluir autorização
            UsernamePasswordAuthenticationToken authToken = getAuthentication(token.substring(7));
            if(authToken != null) {

                //detentor de contexto de segurança
                // pega a autenticação.
                SecurityContextHolder.getContext().setAuthentication(authToken);
                // Guarda informações do usuário autenticado no contexto do Spring
                // Essa informação pode ser utilizada dentro dos controllers da aplicação
            }
        }
        chain.doFilter(request, response);
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token){
        String login = jwtUtils.getLogin(token);
        if(login == null) {
            return null;
        }
        return  new UsernamePasswordAuthenticationToken(login, null, new ArrayList<>());
    }
}
