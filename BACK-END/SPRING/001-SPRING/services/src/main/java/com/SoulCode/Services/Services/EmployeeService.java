package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.Cargo;
import com.SoulCode.Services.Models.Employee;
import com.SoulCode.Services.Repositories.CargoRepository;
import com.SoulCode.Services.Repositories.EmployeeRepository;
import com.SoulCode.Services.Services.Exceptions.DataIntegrityViolationException;
import com.SoulCode.Services.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviços correspondem aos métodos CRUD dentro da tabela
@Service
public class EmployeeService {

    // Injeção de dependência --> criar um objeto de outra interface
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CargoRepository cargoRepository;


    //READ. Serviço 01: Leitura de dados na tabela funcionários
    // findAll --> método do spring JPA que busca todos os registros de uma tabela
    @Cacheable("employeeCache")
    public List<Employee> showAllEmployees  (){
        return employeeRepository.findAll();
    }

    //READ. Serviço 02: Buscar apenas um funcionário pelo seu ID (Primary Key)
    @Cacheable(value = "employeeCache", key = "#idEmployee")
    public Employee showAnEmployeeById(Integer idEmployee) throws EntityNotFoundException {
        // Caso dê erro de not found o optional permite deixar a aplicação rodando.
        Optional<Employee> employee = employeeRepository.findById(idEmployee);
        return employee.orElseThrow(
                () -> new EntityNotFoundException("Funcionário não encontrado: " + idEmployee)
        );
    }



    //READ. Serviço 03: Buscar funcionario pelo email
    @Cacheable(value = "employeeCache", key = "#email")
    public Employee  showAnEmployeeByEmail(String email){
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        return employee.orElseThrow();
    }

    // CREATE. Serviço 04: Cadastrar um funcionário
    @CachePut(value ="employeeCache", key = "#idCargo")
    public Employee registerNewEmployee(Employee employee, Integer idCargo) throws DataIntegrityViolationException {
        try{
        employee.setIdEmployee(null);
        Optional<Cargo> cargo = cargoRepository.findById(idCargo);
        employee.setCargo(cargo.get());
        return employeeRepository.save(employee);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não foi possível cadastrar o funcionário");
        }
    }

    // DELETE. SERVIÇO 05: Deletar um funcionário
    @CacheEvict(value = "employeeCache", key ="#idEmployee", allEntries = true)
    public void deleteEmployee(Integer idEmployee){
        employeeRepository.deleteById(idEmployee);
    }

    // UPDATE. SERVIÇO 06: Atualizar um funcionário
    public Employee putEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    // UPDATE. SERVIÇO 07: SALVAR FOTO NO BANCO DE DADOS
    @CachePut("employeeCache")
    public Employee savePhoto(Integer IdEmployee, String pathPhoto){
        Employee employee = showAnEmployeeById(IdEmployee);
        employee.setPhoto(pathPhoto);
        return employeeRepository.save(employee);
    }

    // READ. SERVIÇO 08. Buscar todos os funcionários pelo idCargo
    @Cacheable(value = "employeeCache",key = "#idCargo")
    public List<Employee> findEmployeeByIdCargo(Integer idCargo){
//        Optional<Cargo> cargo = cargoRepository.findById(idCargo);
        return employeeRepository.findEmployeeByIdCargo(idCargo);
    }

}
