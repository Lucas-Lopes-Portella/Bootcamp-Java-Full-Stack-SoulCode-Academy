package com.SoulCode.Services.Repositories;

import com.SoulCode.Services.Models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CalledRepository extends JpaRepository<Called, Integer> {
    List<Called> findByClient(Optional<Client> client);
    List<Called> findByEmployee(Optional<Employee> employee);

    //forma de fazer consultas do SQL quando não existe método no JPA
    @Query(value = "SELECT * FROM called WHERE status =:status", nativeQuery = true)
    List<Called> findByStatus(String status);

    @Query (value = "SELECT * FROM called WHERE date_register BETWEEN :dateI AND :dateII", nativeQuery = true )
    List<Called> findByDateRange(Date dateI, Date dateII);




}
