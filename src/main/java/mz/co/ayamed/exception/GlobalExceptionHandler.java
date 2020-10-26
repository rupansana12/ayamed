package mz.co.ayamed.exception;

import lombok.extern.slf4j.Slf4j;
import mz.co.ayamed.io.ResponseOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseOutput<String>> handle(Exception ex, WebRequest request) throws Exception {
        ResponseOutput<String> errors = new ResponseOutput<>();
        errors.setMessage(ex.getMessage());
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ResponseEntity<ResponseOutput<String>> handleNotFound(Exception ex, WebRequest request) throws Exception {
        ResponseOutput<String> errors = new ResponseOutput<>();
        errors.setMessage(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
