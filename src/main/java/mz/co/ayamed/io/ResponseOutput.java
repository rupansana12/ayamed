package mz.co.ayamed.io;

import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

//@Builder
@Data
@NoArgsConstructor
public class ResponseOutput<T> {

    private HttpStatus status;
    private String message;
    private T data;

}
