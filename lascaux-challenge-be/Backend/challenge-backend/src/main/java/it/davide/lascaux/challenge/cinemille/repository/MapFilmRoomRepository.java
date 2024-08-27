package it.davide.lascaux.challenge.cinemille.repository;

import it.davide.lascaux.challenge.cinemille.entity.MapFilmRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MapFilmRoomRepository extends JpaRepository<MapFilmRoom, Long> {

    @Query("select mfr1_0 " +
            "from MapFilmRoom mfr1_0 " +
            "where mfr1_0.isInProgramming = :isInProgramming and " +
                "(mfr1_0.programmingStartDate>= :startDate or mfr1_0.programmingEndDate<= :endDate)")
    List<MapFilmRoom> findFilmByFilter(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("isInProgramming") boolean isInProgramming
    );

}