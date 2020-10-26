package mz.co.ayamed.exception;


public class ApiExceptionHandler extends Exception {

    public ApiExceptionHandler() {
    }

    public ApiExceptionHandler(String message) {
        super(message);
    }

    public ApiExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiExceptionHandler(Throwable cause) {
        super(cause);
    }
}
