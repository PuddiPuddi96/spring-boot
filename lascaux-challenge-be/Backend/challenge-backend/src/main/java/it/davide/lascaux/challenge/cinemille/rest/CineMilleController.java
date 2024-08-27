package it.davide.lascaux.challenge.cinemille.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.davide.lascaux.challenge.cinemille.model.FilmsResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import it.davide.lascaux.challenge.cinemille.model.common.Result;
import it.davide.lascaux.challenge.cinemille.service.CineMilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CineMilleController {

    private final CineMilleService cineMilleService;

    @Autowired
    public CineMilleController(CineMilleService cineMilleService) {
        this.cineMilleService = cineMilleService;
    }

    @Operation(method = "POST", summary = "", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "404", description = "")
    })
    @PostMapping("/get-films-by-filter")
    public ResponseEntity<Result<List<FilmsResponse>>> getFilmsByFilter(
            @RequestBody GetFilmsByFilterRequest request) {

        Result<List<FilmsResponse>> response = new Result<>();

        List<FilmsResponse> result = cineMilleService.getFilmsByFilter(request);

        response.setData(result);
        response.success(HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
