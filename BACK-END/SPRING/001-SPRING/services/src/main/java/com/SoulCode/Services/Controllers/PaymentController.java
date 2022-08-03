package com.SoulCode.Services.Controllers;

import com.SoulCode.Services.Models.Address;
import com.SoulCode.Services.Models.Called;
import com.SoulCode.Services.Models.Payment;
import com.SoulCode.Services.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/services")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    // Controle do SERVIÇO 01. (READ)

    @GetMapping("/payment")
    public List<Payment> showAllPayments(){
        List<Payment> payment = paymentService.showAllPayments();
        return payment;
    }

    // Controle do SERVIÇO 02. (READ)
    @GetMapping("/payment/{idPayment}")
    ResponseEntity<Payment> showAnPaymentsById(@PathVariable Integer idPayment) {
        Payment payment = paymentService.showAnPaymentsById(idPayment);
        return ResponseEntity.ok().body(payment);
    }


    // Controle do SERVIÇO 08. (READ)
    @GetMapping("/calledPaymentClient")
    List<List> findPaymentCalledClient(){
        return paymentService.findPaymentCalledClient();

    }


    // Controle do SERVIÇO 06 (READ)
    @GetMapping("/paymentByStatus")
    public List<Payment> findByStatusPayment (@RequestParam("statusPayment") String statusPayment){
        List<Payment> payment = paymentService.findByStatusPayment(statusPayment);
        return payment;
    }




    // Controle do SERVIÇO 03. (CREATE)
    @PostMapping("/registerPayment/{idCalled}")
    public ResponseEntity<Payment> registerNewPayment(@RequestBody Payment payment,
                                                      @PathVariable Integer idCalled){
        payment = paymentService.registerNewPayment(payment,idCalled);
        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(payment.getIdPayment()).toUri();
        return  ResponseEntity.created(newUri).body(payment);
    }










//     Controle do SERVIÇO 04. (DELETE)
//    @DeleteMapping("/deletePayment/{idPayment}")
//    public ResponseEntity<Void> deletePayment(@PathVariable Integer idPayment){
//        paymentService.deletePayment(idPayment);
//        return ResponseEntity.ok().build();
//    }

    // Controle do SERVIÇO 05: (UPDATE)
    @PutMapping("/putPayment/{idPayment}")
    public ResponseEntity<Payment> putPayment(@PathVariable Integer idPayment, @RequestBody Payment payment){
        payment.setIdPayment(idPayment);
        paymentService.putPayment(payment);
        return ResponseEntity.ok().body(payment);
    }



    // Controle do SERVIÇO 07 (UPDATE)
    @PutMapping("/putStatusPayment/{idPayment}")
    public ResponseEntity<Payment> editStatusPayment(@PathVariable Integer idPayment, @RequestParam("statusPayment") String statusPayment){
        paymentService.editStatusPayment(idPayment,statusPayment);
        return ResponseEntity.noContent().build();
    }



}
