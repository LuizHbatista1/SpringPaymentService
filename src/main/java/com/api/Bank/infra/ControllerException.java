package com.api.Bank.infra;

import com.api.Bank.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("error is not possible make this action ! ","400");
        return ResponseEntity.badRequest().body(exceptionDTO);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threa404(EntityNotFoundException exception){

        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threaGeneralException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);

    }

}
