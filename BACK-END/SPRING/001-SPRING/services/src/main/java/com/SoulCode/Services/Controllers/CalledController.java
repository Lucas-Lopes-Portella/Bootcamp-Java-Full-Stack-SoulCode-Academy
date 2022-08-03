    package com.SoulCode.Services.Controllers;

    import com.SoulCode.Services.Models.Called;
    import com.SoulCode.Services.Services.CalledService;
    import org.aspectj.weaver.ast.Call;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.net.URI;
    import java.util.Date;
    import java.util.List;

    @CrossOrigin
    @RestController
    @RequestMapping("/services")
    public class CalledController {

        @Autowired
        CalledService calledService;

        // Controle do SERVIÇO 01. (READ)
        // Método Get permite fazer a busca de chamados
        @GetMapping("/called")
        public List<Called> showAllClients(){
            List<Called> calleds = calledService.showAllCalleds();
            return calleds;
        }

        // Controle do SERVIÇO 02. (READ)
        // ResponseEntity retorna todos os dados da entidade
        // @PathVariable --> informa que o ID será enviado pela URL da requisição
        @GetMapping("/called/{idCalled}")
        public ResponseEntity<Called> showAnCalledById(@PathVariable Integer idCalled){
            Called called = calledService.showAnCalledById(idCalled);
            return ResponseEntity.ok().body(called);
        }

        // Controle do SERVIÇO 03. (READ)
        @GetMapping("/calledClient/{idClient}")
        public List<Called> fetchCalledFromTheClient(@PathVariable Integer idClient){
            List<Called> called = calledService.fetchCalledFromTheClient(idClient);
            return called;
        }

        // Controle do SERVIÇO 04. (READ)
        @GetMapping("/calledEmployee/{idEmployee}")
        public List<Called> fetchCalledFromTheEmployee(@PathVariable Integer idEmployee){
            List<Called> called = calledService.fetchCalledFromTheEmployee(idEmployee);
            return called;
        }

        // Controle do SERVIÇO 05. (READ)
        @GetMapping("/calledStatus")
        public List<Called> fetchCalledFromTheStatus(@RequestParam("status") String status) {
            List<Called> called = calledService.fetchCalledFromTheStatus(status);
            return called;
        }

        //Controle do SERVIÇO 06. (READ)
        @GetMapping("/calledByDateRange")
        public List<Called> findByDateRange(@RequestParam("dateI") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateI, @RequestParam("dateII") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date dateII){
            List<Called> called = calledService.findByDateRange(dateI,dateII);
            return called;
        }

        // Controle do SERVIÇO 07. (CREATE)
        @PostMapping("/postCalled/{idClient}")
        public ResponseEntity<Called> RegisterCalled(@PathVariable Integer idClient, @RequestBody Called called){
            called = calledService.RegisterCalled(called,idClient);
            // neste momento o chamado já foi cadastrado no DB, agora é necessário criar o caminho (URI) para que este novo chamado possa ser acessado
            // ServletUriComponentsBuilder -- cria o caminho
            // fromCurrentRequest()
            URI newUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(called.getIdCalled()).toUri();
            return ResponseEntity.created(newUri).body(called);
        }

        //Controle do SERVIÇO 08. (DELETE)
        @DeleteMapping("/deleteCalled/{idCalled}")
        public ResponseEntity<Void> deleteCalled(@PathVariable Integer idCalled){
            calledService.deleteCalled(idCalled);
            return ResponseEntity.noContent().build();
        }

        //Controle do SERVIÇO 09. (UPDATE)
        // Necessário utilizar o método http do tipo put
        @PutMapping("/putCalled/{idCalled}")
        public ResponseEntity<Called> putCalled(@PathVariable Integer idCalled, @RequestBody Called called){
            called.setIdCalled(idCalled);
            called = calledService.putCalled(called,idCalled);
            return ResponseEntity.ok().build();
        }

        //Controle do SERVIÇO 10. (UPDATE)
        @PutMapping("/calledAssignEmployee/{idCalled}/{idEmployee}")
        public ResponseEntity<Called> assignEmployee(@PathVariable Integer idCalled, @PathVariable Integer idEmployee){
            calledService.assignEmployee(idCalled,idEmployee);
            return ResponseEntity.ok().build();
        }

        // Controle do SERVIÇO 11. (UPDATE)
        @PutMapping("/calledModifyStatus/{idCalled}")
        public ResponseEntity<Called> modifyStatus(@PathVariable Integer idCalled, @RequestParam("status") String status ){
            calledService.modifyStatus(idCalled, status);
        return ResponseEntity.ok().build();
        }


    }
