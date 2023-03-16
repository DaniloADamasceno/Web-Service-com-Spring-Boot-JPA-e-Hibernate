package com.modulo23.resources.exceptions;

import com.modulo23.services.exceptions.DatabaseException;
import com.modulo23.services.exceptions.ResourceNotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice // -->  Anotação que permite que a classe intercepte as exceções que ocorrerem para elas poderem ser tratadas
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoudException.class) // --> Anotação que permite que o método intercepte a exceção
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoudException notFoudException, HttpServletRequest request) {
        String error = "⚠️RESOURCE NOT FOUND ⚠️/⚠️ RECURSO NÂO ENCONTRADO ⚠️";
        HttpStatus statusHttp = HttpStatus.NOT_FOUND;
        StandartError standartError = new StandartError(Instant.now(), statusHttp.value(), error,
                notFoudException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @ExceptionHandler(DatabaseException.class) // --> Anotação que permite que o método intercepte a exceção
    public ResponseEntity<StandartError> databaseError(DatabaseException databaseException, HttpServletRequest request) {
        String error = "⚠️DATABASE ERROR ⚠️/⚠️ ERRO DE INTERIDADE NO BANCO DE DADOS ⚠️";
        HttpStatus statusHttp = HttpStatus.BAD_REQUEST;
        StandartError standartError = new StandartError(Instant.now(), statusHttp.value(), error,
                databaseException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

}
