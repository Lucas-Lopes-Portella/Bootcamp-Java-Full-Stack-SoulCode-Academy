package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.*;
import com.SoulCode.Services.Repositories.AddressRepository;
import com.SoulCode.Services.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ClientRepository clientRepository;




    //READ. Serviço 01: Leitura de dados na tabela endereço
    @Cacheable("addressCache")
    public List<Address> showAllAddress (){
        return addressRepository.findAll();
    }

    //READ. Serviço 02: Buscar apenas um endereço pelo seu ID (Primary Key)
    @Cacheable(value = "addressCache", key = "#idAddress")
    public Address showAnAddressById(Integer idAddress){
        Optional<Address> address = addressRepository.findById(idAddress);
        return address.orElseThrow();
    }


    // CREATE. SERVIÇO 03: Cadastrar um endereço
    // Regra 01: O cliente já deve estar cadastrado
    // Regra 02: No momento do cadastro do endereço, é preciso passar o id do cliente dono deste endereço
    // Regra 03: O id do endereço é o mesmo id do cliente
    // Regra 04: Não permitir que um endereço seja salvo sem a existência do respectivo cliente


    // possibilidade 2:  public Address registerNewAddress(Address address, Integer idClient) throws Exception { ... }
    @CachePut(value = "addressCache", key = "#idClient")
    public Address registerNewAddress(Address address, Integer idClient) {

        // declaração de um optional de cliente e atribuindo para este os dados do cliente que receberá o endereço
            Optional<Client> client = clientRepository.findById(idClient);

            // possibilidade 2: if(client.isPresent()){ ... }
            if(idClient == client.get().getIdClient()){

                address.setIdAddress(idClient);
                addressRepository.save(address);

                client.get().setAddress(address);
                clientRepository.save(client.get());

                return address;

            } else {
                // possibilidade 2: throw new Exception();
                throw new NoSuchElementException("Não há id pare este cliente");
            }

    }


           // subir optional
            // criar if
           //  criar exc ..



//     DELETE. SERVIÇO 04: Deletar um endereço
//    public void deleteAddress(Integer idAddress){
//
//        addressRepository.deleteById(idAddress);
//    }

    // UPDATE. SERVIÇO 05: Atualizar um endereço
    @CachePut(value = "addressCache", key = "#address.idAddress")
    public Address putAddress(Address address){

        return addressRepository.save(address);
    }

}
