package com.td.tornelli.mapper;

import com.td.tornelli.dao.UserDao;
import com.td.tornelli.dto.UserDtoOutput;
import org.springframework.stereotype.Component;

@Component
public class MapperUserDaoToUserDto {
    public UserDtoOutput mapper(UserDao input){
        UserDtoOutput output = new UserDtoOutput();
        output.setId(input.getId());
        output.setNome(input.getNome());
        output.setCognome(input.getCognome());
        output.setEmail(input.getEmail());
        output.setTelefono(input.getTelefono());
        output.setRuolo(input.getRuolo());
        output.setAzienda(input.getAzienda());
        output.setDataRegistrazione(input.getDataRegistrazione());
        output.setDataUltimoAggiornamento(input.getDataUltimoAggiornamento());
        output.setStato(input.getStato());
        output.setPresente(input.getPresente());
        output.setBadgeId(input.getBadgeId());
        return output;
    }
}
