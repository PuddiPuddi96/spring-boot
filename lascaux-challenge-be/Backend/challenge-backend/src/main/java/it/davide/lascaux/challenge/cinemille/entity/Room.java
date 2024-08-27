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
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "number")
    private int number;

    @Column(name = "flag_imax")
    private boolean flagImax;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MapFilmRoom> mapFilmRooms;

}
