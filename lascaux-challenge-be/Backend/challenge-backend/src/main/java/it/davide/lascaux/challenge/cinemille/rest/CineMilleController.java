package it.davide.lascaux.challenge.cinemille.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.davide.lascaux.challenge.cinemille.model.FilmsResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import it.davide.lascaux.challenge.cinemille.model.common.Result;
import it.davide.lascaux.challenge.cinemille.service.CineMilleService;
import it.davide.lascaux.challenge.cinemille.util.ExcelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public ResponseEntity<Result<String>> uploadFile(
            @RequestParam("file") MultipartFile file) {

        Result<String> response = new Result<>();
        if (ExcelUtility.hasExcelFormat(file)) {
            try {
                cineMilleService.uploadFilmsFromExcel(file);

                response.setData("The Excel file is uploaded: " + file.getOriginalFilename());
                response.success(HttpStatus.OK.value());

                return ResponseEntity.status(HttpStatus.OK).body(response);
            } catch (Exception exp) {
                response.error(
                        "The Excel file is not upload: " + file.getOriginalFilename() + "!",
                        HttpStatus.EXPECTATION_FAILED.value()
                );
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
            }
        }
        response.error(
                "Please upload an excel file!",
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
