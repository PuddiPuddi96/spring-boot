package it.davide.lascaux.challenge.cinemille.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class FilmsResponse implements Serializable {

    private String title;
    private int duration;
    private int roomNumber;
    private LocalDateTime programmingStartDate;
    private LocalDateTime programmingEndDate;
}
