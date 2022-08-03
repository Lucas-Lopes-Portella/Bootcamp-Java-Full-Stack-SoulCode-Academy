package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.Cargo;
import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Repositories.CargoRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService{

    @Autowired
    CargoRepository cargoRepository;

    //READ. SERVIÇO 01: Leitura de dados na tabela client
    @Cacheable("cargoCache")
    public List<Cargo> showAllCargos() {
        return cargoRepository.findAll();
    }

    // READ. SERVIÇO 02: Buscar apenas um cargo pelo seu ID (Primary Key)
    @Cacheable(value = "cargoCache", key = "#idCargo")
    public Cargo showAnCargoById(Integer idCargo){
        Optional<Cargo> cargo = cargoRepository.findById(idCargo);
        return cargo.orElseThrow();
    }

//    // READ. SERVIÇO 03: Buscar apenas um cargo pelo seu nome

    @Cacheable(value = "cargoCache", key = "#nome")
    public Cargo findByName(String nome){
        Optional<Cargo> cargo = cargoRepository.findByName(nome);
        return cargo.orElseThrow();
    }

    // CREATE. SERVIÇO 04: Criar um cargo
     @CachePut(value = "cargoCache", key = "#cargo.idCargo")
    public Cargo registerNewCargo(Cargo cargo){
        cargo.setIdCargo(null);
        return cargoRepository.save(cargo);
    }

    // DELETE. SERVIÇO 05: Deletar um cargo
    @CacheEvict(value = "cargoCache", key="#idCargo", allEntries = true)
    public void deleteCargo(Integer idCargo){
        cargoRepository.deleteById(idCargo);
    }


    // UPDATE. SERVIÇO 06: Atualizar um cargo
    @CachePut(value = "cargoCache", key = "#cargo.idCargo")
    public Cargo putCargo(Cargo cargo){
        return cargoRepository.save(cargo);
    }
}
