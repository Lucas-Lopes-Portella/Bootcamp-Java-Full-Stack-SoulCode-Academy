package com.SoulCode.Services.Controllers.Exception;

import com.SoulCode.Services.Services.Exceptions.DataIntegrityViolationException;
import com.SoulCode.Services.Services.Exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

//ControllerAdvice é uma bean que identifica uma classe que faz tratamento de exceções
@ControllerAdvice
public class ResourceExceptionHandler {

    // EntityNotFoundException classe de exceção criada em service
    // HttpServletRequest mostra o caminho da requição
    // Bean obrigatória para informar a classe do erro
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError();
       //setTimestamp verifica o momento que aconteceu o erro
        // Instant.now() o exato momento que o erro ocorreu
        error.setTimestamp(Instant.now());

        //HttpStatus mostra o status do erro
        error.setStatus(HttpStatus.NOT_FOUND.value());

        error.setError("Registro não encontrado");

        // vai usar a mensagem de erro da classe criada no service ( EntityNotFoundException )
        error.setMessage(e.getMessage());

        // colocar o caminho da requisição através do request. (uri que foi buscada)
        error.setPath(request.getRequestURI());

        // mostra de onde vem o erro (classe)
         error.setTrace("DataIntegrityViolationException");

         // vai retornar o status que tem como parâmetro o tipo do erro, e inserir no corpo o objeto criado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> DataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setError("Atributo não pode ser duplicado");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        error.setTrace("DataIntegrityViolationException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
