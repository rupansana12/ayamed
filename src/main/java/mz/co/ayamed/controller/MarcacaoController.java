package mz.co.ayamed.controller;

import mz.co.ayamed.domain.*;
import mz.co.ayamed.exception.ApiExceptionHandler;
import mz.co.ayamed.io.ResponseOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("marcacao")
public interface MarcacaoController {

    @PostMapping("consulta/{email}")
    ResponseEntity<ResponseOutput<MarcarConsulta>> save(@RequestBody MarcarConsulta marcarConsulta,@PathVariable("email") String email) throws ApiExceptionHandler;

    @PostMapping("exame/{email}")
    ResponseEntity<ResponseOutput<MarcarExame>> save(@RequestBody MarcarExame marcarExame,@PathVariable("email") String email) throws ApiExceptionHandler;

    @PostMapping("hemodialises/{email}")
    ResponseEntity<ResponseOutput<MarcarHemodialise>> save(@RequestBody MarcarHemodialise marcarHemodialise,@PathVariable("email") String email) throws ApiExceptionHandler;

}
