package it.davide.lascaux.challenge.cinemille.exception;

public class RoomException extends RuntimeException {

    public RoomException(String message) {
        super(message);
    }

    public RoomException(Throwable cause) {
        super(cause);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
