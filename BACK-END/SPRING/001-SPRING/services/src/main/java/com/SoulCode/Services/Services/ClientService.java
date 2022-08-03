package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Repositories.ClientRepository;
import com.SoulCode.Services.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Trata-se de uma classe de serviços de clientes
@Service
public class ClientService {

    // Injeção de dependência
    @Autowired
    ClientRepository clientRepository;

    //READ. SERVIÇO 01: Leitura de dados na tabela client
    @Cacheable("clientCache") // só irar chamar o return caso o cache expirar
    //
    public List<Client> showAllClients() {
        return clientRepository.findAll();
    }

    // READ. SERVIÇO 02: Buscar apenas um cliente pelo seu ID (Primary Key)
    @Cacheable(value = "clientCache", key = "#idClient") // ex: clientCache::1
    public Client showAnClientById(Integer idClient) throws EntityNotFoundException{
        Optional<Client> client = clientRepository.findById(idClient);
        return client.orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado: " + idClient)
        );
    }

    // READ. SERVIÇO 03: Buscar cliente pelo email
     @Cacheable(value = "clientCache", key = "#email")
    public Client showAnClientByEmail(String email){
        Optional<Client> client = clientRepository.findByEmail(email);
        return client.orElseThrow();
    }

    // CREATE. SERVIÇO 04: Cadastrar um cliente
    @CachePut(value = "clientesCache", key = "#client.idClient")
    public Client registerNewClient(Client client){
        client.setIdClient(null);
        return clientRepository.save(client);
    }


    // DELETE. SERVIÇO 05: Deletar um cliente
    // allEntreies true informa que irá apagar todos os valores associados ao valor (value) e a chave (key) dentro do redis
    @CacheEvict(value = "clientCache", key="#idClient", allEntries = true)
    public void deleteClient(Integer idClient){
        clientRepository.deleteById(idClient);
    }

    // UPDATE. SERVIÇO 06: Atualizar um cliente
    @CachePut(value = "clientCache", key = "#client.idClient")
    public Client putClient(Client client){
        return clientRepository.save(client);
    }
}

