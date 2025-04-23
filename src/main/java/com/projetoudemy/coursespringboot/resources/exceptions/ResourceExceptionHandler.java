package com.projetoudemy.coursespringboot.resources.exceptions;

import com.projetoudemy.coursespringboot.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //Intercepta as exções para que esse objeto efetue um prossivel tratamento
public class ResourceExceptionHandler {

    @ExceptionHandler (ResourceNotFoundException.class) //Fala ao metodo que ele ira captar toda a exceção do tipo especificado e ira tratar-la dentro del
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status,error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
