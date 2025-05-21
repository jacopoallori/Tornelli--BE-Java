package com.td.tornelli.controller;

import com.td.tornelli.dto.UserDtoInput;
import com.td.tornelli.dto.UserDtoOutput;
import com.td.tornelli.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    //Endpoint per registrazione di un nuovo utente
    @PostMapping("/api/users")
    public ResponseEntity registerUser(@RequestBody @Valid UserDtoInput user){
        UserDtoOutput response = service.registerUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Endpoint per ottenere i dati di un utente tramite id
//    @GetMapping("/api/users/{id}")
//    public ResponseEntity getUser(@PathVariable String id){
//        logger.info("Invocato EndPoint getUser");
//        logger.info(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    //Endpoint per ottenere la lista degli utenti
//    @GetMapping("/api/users/")
//    public ResponseEntity getlistUsers(){
//        List<UserDtoInput> reponse = service.getListUsers();
//        return new ResponseEntity<>(reponse, HttpStatus.OK);
//    }
//
//    //Endpoint per aggiornare i dati di un utente
//    @PutMapping("/api/users/{id}")
//    public ResponseEntity updateUser(@PathVariable String id){
//        logger.info("Invocato EndPoint updateUser");
//        logger.info(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    //Endpoint per eliminare un utente
//    @DeleteMapping("/api/users/{id}")
//    public ResponseEntity deleteUser(@PathVariable String id){
//        logger.info("Invocato EndPoint deleteUser");
//        logger.info(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}