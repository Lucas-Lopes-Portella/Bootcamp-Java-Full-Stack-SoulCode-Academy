package com.SoulCode.Services.Controllers;

import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Services.ClientService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.annotation.Retention;
import java.net.URI;
import java.util.List;

// Trata-se de uma classe de controle de clientes
@CrossOrigin
@RestController
// Rota base: tem que ficar igual para a aplicação inteira
@RequestMapping("/services")
public class ClientController {

    // Injeção de dependência da classe de serviço dos clientes
    @Autowired
    ClientService clientService;

    // Controle do SERVIÇO 01. (READ)
    // Método Get permite fazer a busca de usuários
    @GetMapping("/client")
    public List<Client> showAllClients(){
        List<Client> clients = clientService.showAllClients();
        return clients;
    }

    // Controle do SERVIÇO 02. (READ)
    // ResponseEntity retorna todos os dados da entidade
    // @PathVariable --> informa que o ID será enviado pela URL da requisição
    @GetMapping("/client/{idClient}")
    public ResponseEntity<Client> showAnClientById(@PathVariable Integer idClient){
        Client client = clientService.showAnClientById(idClient);
        return ResponseEntity.ok().body(client);
    }

    // Controle do SERVIÇO 03. (READ)
    @GetMapping("/emailClient/{emailClient}")
    public ResponseEntity<Client> showAnClientByEmail(@PathVariable String emailClient){
        Client client = clientService.showAnClientByEmail(emailClient);
        return ResponseEntity.ok().body(client);
    }

    // Controle do SERVIÇO 04. (CREATE. Cadastro de cliente)
    // RequestBody --> Os dados são passados para a tabela através do corpo da requisição.
    @PostMapping("/registerClient")
    public ResponseEntity<Client> registerNewClient(@RequestBody Client client){
        client = clientService.registerNewClient(client);
        // criar-se uma URI para registro do funcionário na tabela
        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(client.getIdClient()).toUri();
        return  ResponseEntity.created(newUri).body(client);
    }

    // Controle do SERVIÇO 05. (DELETE)
    @DeleteMapping("/deleteClient/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer idClient){
        clientService.deleteClient(idClient);
        return ResponseEntity.noContent().build();
    }

    // Controle do SERVIÇO 06: (UPDATE)
    @PutMapping("/putClient/{idClient}")
    public ResponseEntity<Client> putClient(@PathVariable Integer idClient, @RequestBody Client client){
        client.setIdClient(idClient);
        clientService.putClient(client);
        return ResponseEntity.noContent().build();
    }

}
