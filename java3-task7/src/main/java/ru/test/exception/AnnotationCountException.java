package ru.test.exception;

/**
 * Created by thetekst on 22.06.17.
 */
public class AnnotationCountException extends RuntimeException {

    public AnnotationCountException(String message) {
        super(message);
    }

    public AnnotationCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
