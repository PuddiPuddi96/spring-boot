package it.davide.lascaux.challenge.cinemille.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class GetFilmsByFilterRequest implements Serializable {

    @Schema(
            name = "startDate",
            description = "This field indicating the programming start date for which to filter",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private LocalDateTime startDate;

    @Schema(
            name = "endDate",
            description = "This field indicating the programming end date for which to filter",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private LocalDateTime endDate;

}
