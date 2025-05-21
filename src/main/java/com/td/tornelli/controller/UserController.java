package com.td.tornelli.controller;

import com.td.tornelli.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/api/users")
    public ResponseEntity registerUser(@RequestBody @Valid User user){
        logger.info("Invocato EndPoint : '/api/users' ");
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/api/users/${id}")
//    public ResponseEntity getUser(@PathVariable String id){
//        logger.info("Invocato EndPoint : '/api/users/{id}' ");
//        logger.info(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}