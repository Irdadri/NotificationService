package com.example.NotificationService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//modello per lista prenotazioni
public class PrenotazioneDTO {
    private int id;
    private String nomeUtente;
    private String cognomeUtente;
    private String citta;
    private String indirizzo;
    @JsonProperty("nstanza")
    private String nStanza;
    @JsonProperty("npostazione")
    private int nPostazione;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataInizio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataFine;

    private String stato;

    @Override
    public String toString() {
        return "codice prenotazione: " + id + "<br>" +
                "citta: " + citta + "<br>" +
                "indirizzo: " + indirizzo + "<br>" +
                "numero stanza: " + nStanza + "<br>" +
                "numero postazione: " + nPostazione + "<br>" +
                "data inizio: " + dataInizio + "<br>" +
                "data fine: " + dataFine + "<br>" +
                "stato: " + stato;
    }

}
