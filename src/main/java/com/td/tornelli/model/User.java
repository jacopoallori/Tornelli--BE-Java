package com.td.tornelli.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

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

    UserRuolo ruolo;

    String azienda;

    UserStato stato;

    Boolean presente;

    String badgeId;
}
