package com.SoulCode.Services.Repositories;

import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByEmail(String email);

    // Optional<Employee> findByNameAndEmail(String name, String email);

}
