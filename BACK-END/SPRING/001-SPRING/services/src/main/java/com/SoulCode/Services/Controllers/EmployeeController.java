package com.SoulCode.Services.Controllers;

// onde os dados e métodos serão expostos para que o front-end possa consumir.
// mapear o serviço do employee CRUD

import com.SoulCode.Services.Models.Cargo;
import com.SoulCode.Services.Models.Employee;
import com.SoulCode.Services.Services.CargoService;
import com.SoulCode.Services.Services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// CrossOrigin --> aplicações de portas diferentes podem acessar os end points sem dar problemas de CORS
// RequestMapping --> Mapa de requisição
@CrossOrigin
@RestController
@RequestMapping("services")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CargoService cargoService;


    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employees = employeeService.showAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{idEmployee}")
    // ResponseEntity retorna todos os dados da entidade
    // @PathVariable --> informa que o ID será enviado pela URL da requisição
    public ResponseEntity<Employee> showAnEmployeeById(@PathVariable Integer idEmployee){
        Employee employee = employeeService.showAnEmployeeById(idEmployee);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/emailEmployees/{emailEmployee}")
    public ResponseEntity<Employee> showAnEmployeeByEmail(@PathVariable String emailEmployee){
        Employee employee = employeeService.showAnEmployeeByEmail(emailEmployee);
        return ResponseEntity.ok().body(employee);
    }

    // Método para cadastrar
    @PostMapping("/registerEmployee/{idCargo}")
    // RequestBody --> Os dados são passados para a tabela através do corpo da requisição.
    public ResponseEntity<Employee> registerNewEmployee( @RequestBody Employee employee, @PathVariable Integer idCargo){
        employee = employeeService.registerNewEmployee(employee, idCargo);
//        Cargo cargo = cargoService.showAnCargoById(idCargo);
//        employee.setCargo(cargo);
        // linha 52: criar-se uma URI para registro do funcionário na tabela
        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(employee.getIdEmployee()).toUri();
        return ResponseEntity.created(newUri).body(employee);
    }

    @DeleteMapping("/deleteEmployee/{idEmployee}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer idEmployee){
        employeeService.deleteEmployee(idEmployee);
                return ResponseEntity.noContent().build();
    }

    @PutMapping("/putEmployee/{idEmployee}")
    public ResponseEntity<Employee> putEmployee(@PathVariable Integer idEmployee, @RequestBody Employee employee){
        employee.setIdEmployee(idEmployee);
        employeeService.putEmployee(employee);
        return ResponseEntity.noContent().build();
    }


@GetMapping("/employeesCargo/{idCargo}")
    public List<Employee> findEmployeeByIdCargo(@PathVariable Integer idCargo){
        List<Employee> employees = employeeService.findEmployeeByIdCargo(idCargo);
        return employees;
    }

}
