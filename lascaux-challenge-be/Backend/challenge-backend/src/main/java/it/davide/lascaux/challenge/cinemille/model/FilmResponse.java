package it.davide.lascaux.challenge.cinemille.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class FilmResponse implements Serializable {

    private String title;
    private int duration;
    private int roomNumber;
    private LocalDateTime programmingStartDate;
    private LocalDateTime programmingEndDate;
}
