package com.td.tornelli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.td.tornelli.dao.UserDao;
import com.td.tornelli.dto.UserDtoInput;
import com.td.tornelli.dto.UserDtoOutput;
import com.td.tornelli.mapper.MapperUserDaoToUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MockService {
    private final List<UserDtoInput> utenti = new ArrayList<>();

    @Autowired
    MapperUserDaoToUserDto mapper;

    public UserDtoOutput insertUser(UserDtoInput user){
        UserDao userDao =  caricaDatiDaJson("insertUser").stream()
                .findFirst()
                .get();

        return mapper.mapper(userDao);
    }

//    public List<UserDTO> getListUtenti(){
//        return utenti;
//    }
//
//    public Optional<UserDTO> getUtenteById(Long id) {
//        return utenti.stream()
//                .filter(u -> u.getId().equals(id))
//                .findFirst();
//    }

    private List<UserDao> caricaDatiDaJson(String nomeFile) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("mocks/" + nomeFile + ".json")) {
            System.out.println("Qui ci siamo");
            if (is == null) throw new RuntimeException("File mocks/listaUtenti.json non trovato");
            return Arrays.asList(mapper.readValue(is, UserDao[].class));
        } catch (IOException e) {
            throw new RuntimeException("Errore durante la lettura di "+ nomeFile +".json", e);
        }
    }
}
