package it.davide.lascaux.challenge.cinemille.service;

import it.davide.lascaux.challenge.cinemille.entity.MapFilmRoom;
import it.davide.lascaux.challenge.cinemille.model.FilmsResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import it.davide.lascaux.challenge.cinemille.repository.MapFilmRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CineMilleServiceImpl implements CineMilleService {

    private final MapFilmRoomRepository mapFilmRoomRepository;

    @Autowired
    public CineMilleServiceImpl(MapFilmRoomRepository mapFilmRoomRepository) {
        this.mapFilmRoomRepository = mapFilmRoomRepository;
    }

    @Override
    public List<FilmsResponse> getFilmsByFilter(GetFilmsByFilterRequest request) {
        List<MapFilmRoom> result = mapFilmRoomRepository
                .findFilmByFilter(
                        request.getStartDate(),
                        request.getEndDate(),
                        request.getIsInProgramming()
                );

        List<FilmsResponse> filmsResponses = new ArrayList<>();
        if(!result.isEmpty()){
            result.forEach(filmRoom ->
                    filmsResponses.add(
                            new FilmsResponse(
                                filmRoom.getFilm().getTitle(),
                                filmRoom.getFilm().getDuration(),
                                filmRoom.getRoom().getNumber(),
                                filmRoom.getProgrammingStartDate(),
                                filmRoom.getProgrammingEndDate()
            )));
        }

        return filmsResponses;
    }
}
