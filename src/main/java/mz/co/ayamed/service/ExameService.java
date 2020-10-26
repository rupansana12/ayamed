package mz.co.ayamed.service;

import mz.co.ayamed.controller.ExameController;
import mz.co.ayamed.domain.Exame;
import mz.co.ayamed.exception.ApiExceptionHandler;
import mz.co.ayamed.exception.NotFoundExceptionHandler;
import mz.co.ayamed.io.ResponseOutput;
import mz.co.ayamed.repository.ExameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExameService implements ExameController {

    private final ExameRepository exameRepository;

    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    @Override
    public ResponseEntity<ResponseOutput<List<Exame>>> listaExame() throws ApiExceptionHandler {
        List<Exame> exames = exameRepository.findAll();
        if (exames.isEmpty()) {
            throw new NotFoundExceptionHandler("O servidor não encontrou nehum exame");
        } else {
            ResponseOutput<List<Exame>> exame = new ResponseOutput<>();
            exame.setData(exames);
            exame.setMessage("200");
            exame.setStatus(HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(exame);
        }
    }
}
