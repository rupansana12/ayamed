package mz.co.ayamed.exception;

public class NotFoundExceptionHandler extends RuntimeException {

    public NotFoundExceptionHandler() {
    }

    public NotFoundExceptionHandler(String message) {
        super(message);
    }

    public NotFoundExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundExceptionHandler(Throwable cause) {
        super(cause);
    }
}
