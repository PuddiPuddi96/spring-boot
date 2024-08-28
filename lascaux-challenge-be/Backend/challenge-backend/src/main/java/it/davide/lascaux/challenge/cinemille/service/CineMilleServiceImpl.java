package it.davide.lascaux.challenge.cinemille.service;

import it.davide.lascaux.challenge.cinemille.entity.Film;
import it.davide.lascaux.challenge.cinemille.entity.MapFilmRoom;
import it.davide.lascaux.challenge.cinemille.entity.Room;
import it.davide.lascaux.challenge.cinemille.model.FilmFromExcel;
import it.davide.lascaux.challenge.cinemille.model.FilmsResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import it.davide.lascaux.challenge.cinemille.repository.FilmRepository;
import it.davide.lascaux.challenge.cinemille.repository.MapFilmRoomRepository;
import it.davide.lascaux.challenge.cinemille.repository.RoomRepository;
import it.davide.lascaux.challenge.cinemille.util.ExcelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class CineMilleServiceImpl implements CineMilleService {

    private final FilmRepository filmRepository;
    private final MapFilmRoomRepository mapFilmRoomRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public CineMilleServiceImpl(FilmRepository filmRepository, MapFilmRoomRepository mapFilmRoomRepository, RoomRepository roomRepository) {
        this.filmRepository = filmRepository;
        this.mapFilmRoomRepository = mapFilmRoomRepository;
        this.roomRepository = roomRepository;
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

    @Override
    public Map<String, Object> getFilmHistory(Integer pageNumber, Integer pageSize) {
        return convertToResponse(mapFilmRoomRepository.getMapFilmRooms(PageRequest.of(pageNumber, pageSize)));
    }

    @Transactional
    @Override
    public void uploadFilmsFromExcel(MultipartFile file) {
        try{
            List<FilmFromExcel> filmsFromExcel = ExcelUtility.getFilmsFromExcel(file.getInputStream());

            if(!filmsFromExcel.isEmpty()){
                filmsFromExcel.forEach(filmFromExcel -> {
                    Film filmSaved = filmRepository.save(new Film(
                            filmFromExcel.getFilmTitle(),
                            filmFromExcel.getFilmGenre(),
                            filmFromExcel.getFilmDuration()
                    ));

                    Optional<Room> room = roomRepository.findById(filmFromExcel.getRoomNumber());
                    room.ifPresent(value -> mapFilmRoomRepository.save(new MapFilmRoom(
                            value,
                            filmSaved,
                            true,
                            filmFromExcel.getProgrammingStartDate(),
                            filmFromExcel.getProgrammingEndDate()
                    )));
                });
            }

        }catch (IOException ex){
            throw new RuntimeException("Excel data is failed to store");
        }
    }

    private Map<String, Object> convertToResponse(final Page<MapFilmRoom> filmRoomPage) {
        List<FilmsResponse> films = new ArrayList<>();
        filmRoomPage.getContent().forEach(filmRoom -> {
            films.add(convertMapFilmRoomToFilmResponse(filmRoom));
        });

        Map<String, Object> result = new HashMap<>();
        result.put("films", films);
        result.put("current-page", filmRoomPage.getNumber());
        result.put("total-items", filmRoomPage.getTotalElements());
        result.put("total-pages", filmRoomPage.getTotalPages());

        return result;
    }

    private FilmsResponse convertMapFilmRoomToFilmResponse(final MapFilmRoom mapFilmRoom){
        Film film = mapFilmRoom.getFilm();
        Room room = mapFilmRoom.getRoom();

        return new FilmsResponse(
                film.getTitle(),
                film.getDuration(),
                room.getNumber(),
                mapFilmRoom.getProgrammingStartDate(),
                mapFilmRoom.getProgrammingEndDate()
        );
    }
}
