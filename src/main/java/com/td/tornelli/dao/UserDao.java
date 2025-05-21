package com.td.tornelli.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.td.tornelli.model.UserRuolo;
import com.td.tornelli.model.UserStato;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {
    @JsonProperty("id_utente")
    String id;
    String nome;
    String cognome;
    String email;
    String telefono;
    String ruolo;
    String azienda;
    @JsonProperty("data_registrazione")
    String dataRegistrazione;
    @JsonProperty("data_ultimo_aggiornamento")
    String dataUltimoAggiornamento;
    String stato;
    Boolean presente;
    String badgeId;
}