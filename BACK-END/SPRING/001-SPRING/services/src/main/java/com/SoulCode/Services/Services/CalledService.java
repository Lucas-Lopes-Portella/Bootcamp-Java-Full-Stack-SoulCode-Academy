package com.SoulCode.Services.Services;

import com.SoulCode.Services.Models.*;
import com.SoulCode.Services.Repositories.CalledRepository;
import com.SoulCode.Services.Repositories.ClientRepository;
import com.SoulCode.Services.Repositories.EmployeeRepository;
import com.SoulCode.Services.Repositories.PaymentRepository;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CalledService {

    @Autowired
    CalledRepository calledRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PaymentRepository paymentRepository;

    //READ. Serviço 01: Leitura de dados na tabela chamados
    @Cacheable("calledCache")
    public List<Called> showAllCalleds (){
        return calledRepository.findAll();
    }

    //READ. Serviço 02: Buscar apenas um funcionário pelo seu ID (Primary Key)
    @Cacheable(value = "calledCache", key = "#idCalled")
    public Called showAnCalledById(Integer idCalled){
        Optional<Called> called = calledRepository.findById(idCalled);
        return called.orElseThrow();
    }

    //READ. Serviço 03: Buscar chamados pelo id do cliente
    @Cacheable(value = "calledCache", key = "#idClient")
    public List<Called> fetchCalledFromTheClient(Integer idClient){
        Optional<Client> client = clientRepository.findById(idClient);
        return calledRepository.findByClient(client);
    }

    // READ. Serviço 04: Buscar chamados pelo id do funcionario
    @Cacheable(value = "calledCache", key = "#idEmployee")
    public List<Called> fetchCalledFromTheEmployee(Integer idEmployee){
        Optional<Employee> employee = employeeRepository.findById(idEmployee);
        return calledRepository.findByEmployee(employee);
    }

    // READ. Serviço 05: Buscar chamados pelo status
    @Cacheable(value = "calledCache", key = "#status")
    public List<Called> fetchCalledFromTheStatus(String status){

        return calledRepository.findByStatus(status);
    }

    // READ. Serviço 06: Buscar chamados por intervalo de data
    @Cacheable("calledCache")
    public List<Called> findByDateRange(Date dateI, Date dateII){
        return calledRepository.findByDateRange(dateI, dateII);
    }

    // CREATE. Serviço 07: Cadastrar um novo chamado.
    // Regra 01: O cliente deve ser incluido no momento do cadastro do chamado
    // Regra 02: Não incluir o funcionário no momento do cadastro do chamado
    // Regra 03: O status do chamado deve estar como "RECEBIDO" no momento do cadastro do chamado
    @CachePut(value = "calledCache", key = "#idClient")
    public Called RegisterCalled(Called called, Integer idClient){
       called.setStatus(StatusCalled.RECEBIDO); // regra 03
       called.setEmployee(null); // regra 02
       Optional<Client> client = clientRepository.findById(idClient); // regra 01
       called.setClient(client.get()); // regra 01
        return calledRepository.save(called);
    }

    // DELETE. Serviço 08: Deletar um chamado
    @CacheEvict(value = "calledCache", key = "#idCalled", allEntries=true)
    public void deleteCalled(Integer idCalled){
        calledRepository.deleteById(idCalled);
    }

    // UPDATE. Serviço 09: Editar um chamado
    // Regra 01: No momento da edição de um chamado devemos preservar o cliente e o funcionário deste chamado
    // Editar os dados do chamado mas continuar com os dados do cliente e os dados do funcionário
    @CachePut(value = "calledCache", key = "#idCalled")

    public Called putCalled(Called called, Integer idCalled){
        // Instanciado um objeto do tipo Chamado para armazenar os dados do chamado antes das alterações
       Called dataCalled = showAnCalledById(idCalled);

       Employee employee = dataCalled.getEmployee();
       Client client = dataCalled.getClient();

       called.setClient(client);
       called.setEmployee(employee);
       return calledRepository.save(called);
    }

    //UPDATE. Serviço 10: Atribuir ou trocar um funcionário de um determinado chamado
    // Regra 01: No momento em que um determinado chamado é atribuido a um funcionário o status do chamado precisa ser alterado para ATRIBUIDO
    @CachePut("calledCache")
    public Called assignEmployee(Integer idCalled, Integer idEmployee){
        // buscar os dados do funcionário que vai ser atribuido a esse chamado
        Optional<Employee> employee = employeeRepository.findById(idEmployee);

        // buscar o chamado para o qual vai ser específicado o funcionário escolhido
        Called called = showAnCalledById(idCalled);

        called.setEmployee(employee.get());
        called.setStatus(StatusCalled.ATRIBUIDO);

        return calledRepository.save(called);
    }

    //UPDATE. Serviço 11: Modificar o status de um chamado
    @CachePut(value = "calledCache", key = "#idCalled")
    public Called modifyStatus(Integer idCalled, String status){
        Called called = showAnCalledById(idCalled);
        if(called.getEmployee()!=null){
            switch (status){
                case "ATRIBUIDO": {
                    called.setStatus(StatusCalled.ATRIBUIDO);
                    break;
                }
                case "RECEBIDO": {
                    called.setStatus(StatusCalled.RECEBIDO);
                    break;
                }
                case "CONCLUIDO": {
                    called.setStatus(StatusCalled.CONCLUIDO);
                    break;
                }
                case "ARQUIVADO": {
                    called.setStatus(StatusCalled.ARQUIVADO);
                    break;
                }
            }
        }
        return calledRepository.save(called);
    }



}
