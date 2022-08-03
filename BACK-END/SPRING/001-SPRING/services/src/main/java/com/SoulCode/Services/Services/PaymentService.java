package com.SoulCode.Services.Services;


import com.SoulCode.Services.Models.*;
import com.SoulCode.Services.Repositories.CalledRepository;
import com.SoulCode.Services.Repositories.PaymentRepository;
import org.aspectj.weaver.ast.Call;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CalledRepository calledRepository;


    //READ. Serviço 01: Leitura de todos os pagamentos
    @Cacheable("paymentCache")
    public List<Payment> showAllPayments (){
        return paymentRepository.findAll();
    }

    // Controle do SERVIÇO 02. (READ)
    @Cacheable(value = "paymentCache", key = "#idPayment")
    public Payment showAnPaymentsById(Integer idPayment){
    Optional<Payment> payment = paymentRepository.findById(idPayment);
        return payment.orElseThrow();
    }

    // READ. SERVIÇO 06: Mostar pagamentos pelo status
    @Cacheable(value = "paymentCache", key = "#statusPayment")
    public List<Payment> findByStatusPayment(String statusPayment){
        return paymentRepository.findByStatusPayment(statusPayment);
    }

    // READ. SERVIÇO 08: Buscar chamado, cliente e pagamento
    @Cacheable("PaymentCalledClientCache")
    public List<List> findPaymentCalledClient() {
        return paymentRepository.findPaymentCalledClient();

    }
    // reportar ao prof sobre fazer sentido ter cache para apresentação da lista. E ao atualizar em outro local e tiver cache para apresentar essa lista, os dados não apareceriam atrasado

    // pode haver chaves com mesmos nomes/parametros em Cacheput?





    // CREATE. SERVIÇO 03: Cadastrar um pagamento
    // Regra 02: No momento do cadastro do pagamento, é preciso passar o id do chamado dono deste pagamento
    // Regra 03: O id do pagamento é o mesmo id do chamado
    // Regra 04: Não permitir que um pagamento seja salvo sem a existência do respectivo chamado


    // possibilidade 2:  public Address registerNewAddress(Address address, Integer idClient) throws Exception { ... }

    @CachePut(value = "paymentCache", key = "#idCalled")
    public Payment registerNewPayment(Payment payment, Integer idCalled) {

        Optional<Called> called = calledRepository.findById(idCalled);

        // possibilidade 2: if(called.isPresent()){ ... }
        if(idCalled == called.get().getIdCalled()){

            payment.setIdPayment(idCalled);
            payment.setStatusPayment(StatusPayment.SENT);
            paymentRepository.save(payment);

            called.get().setPayment(payment);
            calledRepository.save(called.get());



            return payment;

       } else {
            throw new NoSuchElementException();
        }
    }

//     DELETE. SERVIÇO 04: Deletar um pagamento
//    public void deletePayment(Integer idPayment){
//
//        paymentRepository.deleteById(idPayment);
//    }


    // UPDATE. SERVIÇO 05: Atualizar um pagamento
    @CachePut(value="paymentCache", key = "#payment.idPayment")
    public Payment putPayment(Payment payment){

        return paymentRepository.save(payment);
    }



    // UPDATE. SERVIÇO 07: Alterar status do pagamento
    @CachePut(value = "paymentCache", key = "#idPayment")
    public Payment editStatusPayment(Integer idPayment, String statusPayment){
        Payment payment = showAnPaymentsById(idPayment);

        switch (statusPayment){
            case "SENT":
                payment.setStatusPayment(StatusPayment.SENT);
                break;
            case "PAID":
                payment.setStatusPayment(StatusPayment.PAID);
                break;
        }
        return paymentRepository.save(payment);
    }



}