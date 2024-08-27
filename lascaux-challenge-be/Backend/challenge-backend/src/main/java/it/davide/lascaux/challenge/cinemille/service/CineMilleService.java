package it.davide.lascaux.challenge.cinemille.service;

import it.davide.lascaux.challenge.cinemille.model.FilmsResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CineMilleService {

    List<FilmsResponse> getFilmsByFilter(GetFilmsByFilterRequest request);

}
