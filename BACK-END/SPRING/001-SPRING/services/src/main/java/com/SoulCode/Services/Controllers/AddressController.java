package com.SoulCode.Services.Controllers;

import com.SoulCode.Services.Models.Address;
import com.SoulCode.Services.Models.Called;
import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/services")
public class AddressController {

    @Autowired
    AddressService addressService;

    // Controle do SERVIÇO 01. (READ)
    @GetMapping("/address")
    public List<Address> showAllAddress(){
        List<Address> address = addressService.showAllAddress();
        return address;
    }

    // Controle do SERVIÇO 02. (READ)
    @GetMapping("/address/{idAddress}")
    ResponseEntity<Address> showAnAddressById(@PathVariable Integer idAddress) {
    Address address = addressService.showAnAddressById(idAddress);
    return ResponseEntity.ok().body(address);
    }



    // Controle do SERVIÇO 03. (CREATE)
    @PostMapping("/registerAddress/{idClient}")

    // possibilidade 2:
    // try {
    // public ResponseEntity<Address> registerNewAddress(@RequestBody Address address, @PathVariable Integer idClient) { ... }
    // } catch (Exception e) {
    //  return ResponseEntity.badRequest().build();
    //}
    // é recomendável ter o try catch também para a possibilidade 1.
    public ResponseEntity<Address> registerNewAddress(@RequestBody Address address, @PathVariable Integer idClient){
        address = addressService.registerNewAddress(address,idClient);
        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(address.getIdAddress()).toUri();
        return  ResponseEntity.created(newUri).body(address);
    }

//     Controle do SERVIÇO 04. (DELETE)
//    @DeleteMapping("/deleteAddress/{idAddress}")
//    public ResponseEntity<Void> deleteAddress(@PathVariable Integer idAddress){
//        addressService.deleteAddress(idAddress);
//        return ResponseEntity.noContent().build();
//    }

    // Controle do SERVIÇO 05: (UPDATE)
    @PutMapping("/putAddress/{idAddress}")
    public ResponseEntity<Address> putClient(@PathVariable Integer idAddress, @RequestBody Address address){
        address.setIdAddress(idAddress);
        addressService.putAddress(address);
        return ResponseEntity.ok().body(address);
    }




}
