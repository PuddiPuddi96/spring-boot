package it.davide.lascaux.challenge.cinemille.repository;

import it.davide.lascaux.challenge.cinemille.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
