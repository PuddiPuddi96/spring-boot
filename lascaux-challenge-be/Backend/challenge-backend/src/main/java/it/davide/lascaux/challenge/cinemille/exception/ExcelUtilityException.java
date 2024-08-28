package it.davide.lascaux.challenge.cinemille.exception;

public class ExcelUtilityException extends RuntimeException {

    public ExcelUtilityException(String message) {
        super(message);
    }

    public ExcelUtilityException(Throwable cause) {
        super(cause);
    }

    public ExcelUtilityException(String message, Throwable cause) {
        super(message, cause);
    }
}
