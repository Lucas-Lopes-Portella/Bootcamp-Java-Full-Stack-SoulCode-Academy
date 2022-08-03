package com.SoulCode.Services.Controllers;


import com.SoulCode.Services.Models.Cargo;
import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class CargoController {

    @Autowired
    CargoService cargoService;


    // Controle do SERVIÇO 01. (READ)
    // Método Get permite fazer a busca de cargos
    @GetMapping("/cargo")
    public List<Cargo> showAllCargos() {
        List<Cargo> cargo = cargoService.showAllCargos();
        return cargo;
    }

    // Controle do SERVIÇO 02. (READ)
    @GetMapping("/cargo/{idCargo}")
    public ResponseEntity<Cargo> showAnCargoById(@PathVariable Integer idCargo) {
        Cargo cargo = cargoService.showAnCargoById(idCargo);
        return ResponseEntity.ok().body(cargo);
    }

    // Controle do SERVIÇO 03. (READ)
    @GetMapping("/cargoNome/{nome}")
    public ResponseEntity<Cargo> findByName(@PathVariable String nome){
        Cargo cargo = cargoService.findByName(nome);
        return ResponseEntity.ok().body(cargo);
    }


    // Controle do SERVIÇO 04. (CREATE)
    @PostMapping("/cargo")
    public ResponseEntity<Cargo> registerNewCargo(@RequestBody Cargo cargo){
        cargo = cargoService.registerNewCargo(cargo);
        // criar-se uma URI para registro do funcionário na tabela
        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(cargo.getIdCargo()).toUri();
        return  ResponseEntity.created(newUri).body(cargo);
    }

    // Controle do SERVIÇO 05. (DELETE)
    @DeleteMapping("/cargo/{idCargo}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Integer idCargo){
        cargoService.deleteCargo(idCargo);
        return ResponseEntity.noContent().build();
    }

    // ResponseEntity retorna todos os dados da entidade
    // Controle do SERVIÇO 06. (UPDATE)
    @PutMapping("/cargo/{idCargo}")
    public ResponseEntity<Cargo> putCargo(@PathVariable Integer idCargo, @RequestBody Cargo cargo){
        cargo.setIdCargo(idCargo);
       cargoService.putCargo(cargo);
       return ResponseEntity.ok().body(cargo);
    }
}

