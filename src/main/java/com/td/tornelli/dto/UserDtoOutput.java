package com.td.tornelli.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDtoOutput {
    String id;
    String nome;
    String cognome;
    String email;
    String telefono;
    String ruolo;
    String azienda;
    String dataRegistrazione;
    String dataUltimoAggiornamento;
    String stato;
    Boolean presente;
    String badgeId;
}
