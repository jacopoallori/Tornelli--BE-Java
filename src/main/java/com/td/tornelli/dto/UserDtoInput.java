package com.td.tornelli.dto;

import com.td.tornelli.model.UserRuolo;
import com.td.tornelli.model.UserStato;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoInput {
    String id_utente;

    @NotNull(message = "Il campo nome è obbligatorio")
    String nome;

    @NotNull(message = "Il campo cognome è obbligatorio")
    String cognome;

    @NotNull(message = "Il campo email è obbligatorio")
    @Email(message = "Il formato della mail non è valido")
    String email;

    @NotNull(message = "Il campo telefono è obbligatorio")
    int telefono;

    @NotNull(message = "Il campo ruolo è obbligatorio")
    UserRuolo ruolo;

    @NotNull(message = "Il campo azienda è obbligatorio")
    String azienda;

    UserStato stato;

    Boolean presente;

    String badgeId;
}