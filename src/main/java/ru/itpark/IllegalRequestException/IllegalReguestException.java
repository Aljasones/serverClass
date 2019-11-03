package ru.itpark.IllegalRequestException;

public class IllegalReguestException extends RuntimeException {
    public IllegalReguestException() {
    }

    public IllegalReguestException(String message) {
        super(message);
    }

    public IllegalReguestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalReguestException(Throwable cause) {
        super(cause);
    }

    public IllegalReguestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
