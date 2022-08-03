package com.SoulCode.Services.Repositories;

import com.SoulCode.Services.Models.Called;
import com.SoulCode.Services.Models.Client;
import com.SoulCode.Services.Models.Payment;
import org.aspectj.weaver.ast.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query(value = "SELECT * FROM payment WHERE status_payment = :statusPayment", nativeQuery = true)
    List<Payment> findByStatusPayment(String statusPayment);

    @Query(value = "SELECT  payment.*, called.id_called, called.tittle, client.id_client, client.name FROM called RIGHT JOIN payment ON  payment.id_payment = called.id_called  LEFT JOIN client ON client.id_client = called.id_called", nativeQuery = true)
    List<List> findPaymentCalledClient();

}

