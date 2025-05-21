package com.td.tornelli.controller;

import com.td.tornelli.error.ErrorValid;
import com.td.tornelli.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> gestisciValidazione(MethodArgumentNotValidException ex) {
        List<ErrorValid> errori = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErrorValid(err.getField(), err.getDefaultMessage()))
                .toList();

        Map<String, Object> corpoRisposta = new HashMap<>();
        corpoRisposta.put("timestamp", LocalDateTime.now().format(Constant.DATE_TIME_FORMATTER));
        corpoRisposta.put("errors", errori);

        return new ResponseEntity<>(corpoRisposta, HttpStatus.BAD_REQUEST);
    }

}