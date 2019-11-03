package ru.itpark.IllegalReguestExceptionMethodException;

public class IllegalReguestExceptionMethodException extends RuntimeException {
    public IllegalReguestExceptionMethodException() {
    }

    public IllegalReguestExceptionMethodException(String message) {
        super(message);
    }

    public IllegalReguestExceptionMethodException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalReguestExceptionMethodException(Throwable cause) {
        super(cause);
    }

    public IllegalReguestExceptionMethodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
