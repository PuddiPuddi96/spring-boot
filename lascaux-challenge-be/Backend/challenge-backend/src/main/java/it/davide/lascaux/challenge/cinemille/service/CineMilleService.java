package it.davide.lascaux.challenge.cinemille.service;

import it.davide.lascaux.challenge.cinemille.model.FilmResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface CineMilleService {

    List<FilmResponse> getFilmsByFilter(GetFilmsByFilterRequest request);
    Map<String, Object> getFilmHistory(final Integer pageNumber, final Integer pageSize);
    void uploadFilmsFromExcel(MultipartFile file);

}
