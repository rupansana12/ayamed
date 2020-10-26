package mz.co.ayamed.service;

import mz.co.ayamed.controller.MarcacaoController;
import mz.co.ayamed.domain.MarcarConsulta;
import mz.co.ayamed.domain.MarcarExame;
import mz.co.ayamed.domain.MarcarHemodialise;
import mz.co.ayamed.exception.ApiExceptionHandler;
import mz.co.ayamed.io.ResponseOutput;
import mz.co.ayamed.repository.MarcarHemodialiseRepository;
import mz.co.ayamed.repository.MarcarConsultaRepository;
import mz.co.ayamed.repository.MarcarExameRepository;
import mz.co.ayamed.util.JavaMailApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarcacaoService implements MarcacaoController {

    private final MarcarConsultaRepository marcarConsultaRepository;
    private final MarcarHemodialiseRepository marcarHemodialiseRepository;
    private final MarcarExameRepository marcarExameRepository;


    public MarcacaoService(MarcarConsultaRepository marcarConsultaRepository, MarcarHemodialiseRepository marcarHemodialiseRepository, MarcarExameRepository marcarExameRepository) {
        this.marcarConsultaRepository = marcarConsultaRepository;
        this.marcarHemodialiseRepository = marcarHemodialiseRepository;
        this.marcarExameRepository = marcarExameRepository;
    }

    @Override
    public ResponseEntity<ResponseOutput<MarcarExame>> save(MarcarExame marcarExame,String email) throws ApiExceptionHandler {
        try {
            MarcarExame exames = marcarExameRepository.save(marcarExame);
            JavaMailApp javaMailApp =new JavaMailApp();
            javaMailApp.email(email);
            ResponseOutput<MarcarExame> responseOutput = new ResponseOutput<>();
            responseOutput.setData(exames);
            responseOutput.setMessage("200");
            responseOutput.setStatus(HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(responseOutput);
        } catch (Exception e) {
            throw new ApiExceptionHandler(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseOutput<MarcarHemodialise>> save(MarcarHemodialise marcarHemodialise,String email) throws ApiExceptionHandler {
        try {
            MarcarHemodialise hemodialises = marcarHemodialiseRepository.save(marcarHemodialise);
            JavaMailApp javaMailApp =new JavaMailApp();
            javaMailApp.email(email);
            ResponseOutput<MarcarHemodialise> responseOutput = new ResponseOutput<>();
            responseOutput.setData(hemodialises);
            responseOutput.setMessage("200");
            responseOutput.setStatus(HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(responseOutput);
        } catch (Exception e) {
            throw new ApiExceptionHandler(e.getMessage());
        }
    }


    @Override
    public ResponseEntity<ResponseOutput<MarcarConsulta>> save(MarcarConsulta marcarConsulta,String email) throws ApiExceptionHandler {
        try {
            MarcarConsulta consultas = marcarConsultaRepository.save(marcarConsulta);
            JavaMailApp javaMailApp =new JavaMailApp();
            javaMailApp.email(email);
            ResponseOutput<MarcarConsulta> responseOutput = new ResponseOutput<>();
            responseOutput.setData(consultas);
            responseOutput.setMessage("200");
            responseOutput.setStatus(HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(responseOutput);
        } catch (Exception e) {
            throw new ApiExceptionHandler(e.getMessage());
        }
    }
}
