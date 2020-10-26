package mz.co.ayamed.controller;

import mz.co.ayamed.domain.Especializacao;
import mz.co.ayamed.domain.Medico;
import mz.co.ayamed.exception.ApiExceptionHandler;
import mz.co.ayamed.io.ResponseOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("especializacao")
public interface EspecializacaoController {

    @GetMapping
    ResponseEntity<ResponseOutput<List<Especializacao>>> especializacaoLista() throws ApiExceptionHandler;

    @GetMapping(path = "{id}/medico")
    ResponseEntity<ResponseOutput<List<Medico>>> listarFuncionariosPorEspecialidade(@PathVariable("id") Long id);

}
