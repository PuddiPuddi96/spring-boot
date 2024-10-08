package it.davide.lascaux.challenge.cinemille.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "map_film_room")
public class MapFilmRoom {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_number")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @Column(name = "is_in_programming")
    private boolean isInProgramming;

    @Column(name = "programming_start_date")
    private LocalDateTime programmingStartDate;

    @Column(name = "programming_end_date")
    private LocalDateTime programmingEndDate;

    public MapFilmRoom(Room room, Film film, boolean isInProgramming, LocalDateTime programmingStartDate, LocalDateTime programmingEndDate) {
        this.room = room;
        this.film = film;
        this.isInProgramming = isInProgramming;
        this.programmingStartDate = programmingStartDate;
        this.programmingEndDate = programmingEndDate;
    }
}
