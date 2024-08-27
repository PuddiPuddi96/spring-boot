package it.davide.lascaux.challenge.cinemille.model.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 8903038957866003289L;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Boolean outcome of the operation",
            allowableValues = {"true", "false"})
    private boolean success;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Coding of the outcome of the operation")
    private int code;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Textual description of the operation")
    private String description;

    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            description = "Any response payload")
    private transient T data;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "")
    private LocalDateTime dateTime;

    public Result(){
        clear();
    }

    public void clear(){
        this.success = false;
        this.code = 0;
        this.data = null;
        this.description = null;
        this.dateTime = LocalDateTime.now();
    }

    public void success(int code) {
        this.success = true;
        this.code = code;
        this.dateTime = LocalDateTime.now();
    }

    public void error(String error, int code) {
        this.success = false;
        this.description = error;
        this.code = code;
        this.data = null;
        this.dateTime = LocalDateTime.now();
    }
}
