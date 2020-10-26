package mz.co.ayamed.controller;

import mz.co.ayamed.domain.Exame;
import mz.co.ayamed.exception.ApiExceptionHandler;
import mz.co.ayamed.io.ResponseOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("exame")
public interface ExameController {

    @GetMapping
    ResponseEntity<ResponseOutput<List<Exame>>>listaExame() throws  ApiExceptionHandler;

}
