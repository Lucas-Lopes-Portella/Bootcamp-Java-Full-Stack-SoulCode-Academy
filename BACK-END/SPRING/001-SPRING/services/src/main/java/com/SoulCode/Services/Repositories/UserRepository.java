package com.SoulCode.Services.Repositories;

import com.SoulCode.Services.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByLogin(String login); // busca pelo email do user
}
