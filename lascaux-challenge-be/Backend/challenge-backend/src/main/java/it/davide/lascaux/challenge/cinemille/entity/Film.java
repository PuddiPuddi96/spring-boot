package it.davide.lascaux.challenge.cinemille.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private int duration;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MapFilmRoom> mapFilmRooms;

}
