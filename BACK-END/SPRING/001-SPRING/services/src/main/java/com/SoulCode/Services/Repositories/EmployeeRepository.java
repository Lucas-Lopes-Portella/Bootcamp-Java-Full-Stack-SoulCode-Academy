package com.SoulCode.Services.Repositories;

import com.SoulCode.Services.Models.Cargo;
import com.SoulCode.Services.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);

    @Query(value="SELECT * FROM employee where id_cargo = :idCargo",nativeQuery = true)
    List<Employee> findEmployeeByIdCargo(Integer idCargo);
//    List<Employee> findEmployeeByIdCargo(Optional<Cargo> cargo);

}
