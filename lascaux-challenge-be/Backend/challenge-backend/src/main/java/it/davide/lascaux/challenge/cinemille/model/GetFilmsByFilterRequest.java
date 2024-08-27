package it.davide.lascaux.challenge.cinemille.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class GetFilmsByFilterRequest implements Serializable {

    @Schema(name = "", description = "", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean isInProgramming = true;

    @Schema(name = "", description = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private LocalDateTime startDate;

    @Schema(name = "", description = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private LocalDateTime endDate;
}
