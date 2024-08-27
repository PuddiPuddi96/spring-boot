package it.davide.lascaux.challenge.cinemille.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmFromExcel implements Serializable {

    private String filmTitle;
    private int filmDuration;
    private String filmGenre;
    private int roomNumber;
    private LocalDateTime programmingStartDate;
    private LocalDateTime programmingEndDate;
}
