package it.davide.lascaux.challenge.cinemille.service;

import it.davide.lascaux.challenge.cinemille.entity.Film;
import it.davide.lascaux.challenge.cinemille.entity.MapFilmRoom;
import it.davide.lascaux.challenge.cinemille.entity.Room;
import it.davide.lascaux.challenge.cinemille.exception.ExcelUtilityException;
import it.davide.lascaux.challenge.cinemille.exception.RoomException;
import it.davide.lascaux.challenge.cinemille.model.FilmFromExcel;
import it.davide.lascaux.challenge.cinemille.model.FilmResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import it.davide.lascaux.challenge.cinemille.repository.FilmRepository;
import it.davide.lascaux.challenge.cinemille.repository.MapFilmRoomRepository;
import it.davide.lascaux.challenge.cinemille.repository.RoomRepository;
import it.davide.lascaux.challenge.cinemille.util.ExcelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public List<FilmResponse> getFilmsByFilter(GetFilmsByFilterRequest request) {
        List<MapFilmRoom> result = mapFilmRoomRepository
                .findFilmByFilter(
                        request.getStartDate(),
                        request.getEndDate()
                );

        if(result.isEmpty()){
            return List.of();
        }

        List<FilmResponse> films = new ArrayList<>();
        result.forEach(mapFilmRoom ->
                films.add(convertMapFilmRoomToFilmResponse(mapFilmRoom)));

        return films;
    }

    @Override
    public Map<String, Object> getFilmHistory(Integer pageNumber, Integer pageSize) {
        return convertToResponse(
                mapFilmRoomRepository.getMapFilmRooms(
                        PageRequest.of(
                                pageNumber,
                                pageSize,
                                Sort.by("programmingStartDate").ascending())));
    }

    @Override
    @Transactional
    public void uploadFilmsFromExcel(MultipartFile file) {
        try{
            List<FilmFromExcel> filmsFromExcel = ExcelUtility.getFilmsFromExcel(file.getInputStream());

            if(filmsFromExcel.isEmpty()){
                return;
            }
            filmsFromExcel.forEach(filmFromExcel -> {
                Film filmSaved = saveFilm(filmFromExcel);
                Room room = getRoom(filmFromExcel.getRoomNumber());
                saveMapFilmRoom(filmSaved, room, filmFromExcel);
            });

        }catch (IOException e){
            throw new ExcelUtilityException("Excel data is failed to store", e);
        }
    }

    private Film saveFilm(FilmFromExcel filmFromExcel){
        return filmRepository.save(new Film(
                filmFromExcel.getFilmTitle(),
                filmFromExcel.getFilmGenre(),
                filmFromExcel.getFilmDuration()
        ));
    }

    private void saveMapFilmRoom(Film film, Room room, FilmFromExcel filmFromExcel){
        mapFilmRoomRepository.save(new MapFilmRoom(
                room,
                film,
                Boolean.TRUE,
                filmFromExcel.getProgrammingStartDate(),
                filmFromExcel.getProgrammingEndDate()
        ));
    }

    private Room getRoom(int roomNumber){
        Optional<Room> room = roomRepository.findById(roomNumber);
        if(room.isEmpty())
            throw new RoomException("Room not found");
        return room.get();
    }

    private Map<String, Object> convertToResponse(final Page<MapFilmRoom> filmRoomPage) {
        List<FilmResponse> films = new ArrayList<>();
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

    private FilmResponse convertMapFilmRoomToFilmResponse(final MapFilmRoom mapFilmRoom){
        Film film = mapFilmRoom.getFilm();
        Room room = mapFilmRoom.getRoom();

        return new FilmResponse(
                film.getTitle(),
                film.getDuration(),
                room.getNumber(),
                mapFilmRoom.getProgrammingStartDate(),
                mapFilmRoom.getProgrammingEndDate()
        );
    }
}
