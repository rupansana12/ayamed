package mz.co.ayamed.service;

import mz.co.ayamed.controller.EspecializacaoController;
import mz.co.ayamed.domain.Especializacao;
import mz.co.ayamed.domain.Medico;
import mz.co.ayamed.exception.ApiExceptionHandler;
import mz.co.ayamed.exception.NotFoundExceptionHandler;
import mz.co.ayamed.io.ResponseOutput;
import mz.co.ayamed.repository.EspecializacaoRepository;
import mz.co.ayamed.repository.MedicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecializacaoService implements EspecializacaoController {

    private final EspecializacaoRepository especializacaoRepository;
    private final MedicoRepository medicoRepository;

    public EspecializacaoService(EspecializacaoRepository especializacaoRepository, MedicoRepository medicoRepository) {
        this.especializacaoRepository = especializacaoRepository;
        this.medicoRepository = medicoRepository;
    }

    public ResponseEntity<ResponseOutput<List<Especializacao>>> especializacaoLista() throws ApiExceptionHandler {
        List<Especializacao> especializacoes = especializacaoRepository.findAll();
        if (especializacoes.isEmpty()) {
            throw new NotFoundExceptionHandler("O servidor não encontrou nehuma especialidade");
        } else {
            ResponseOutput<List<Especializacao>> especializacao = new ResponseOutput<>();
            especializacao.setData(especializacoes);
            especializacao.setMessage("200");
            especializacao.setStatus(HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(especializacao);
        }
    }

    @Override
    public ResponseEntity<ResponseOutput<List<Medico>>> listarFuncionariosPorEspecialidade(Long id) {
        List<Medico> medicos = medicoRepository.buscarProfissionaiasPorEspecialidade(id);
        if (medicos.isEmpty()) {
            throw new NotFoundExceptionHandler("Não existem funcionarios com essa especialidade");
        } else {
            ResponseOutput<List<Medico>> medico = new ResponseOutput<>();
            medico.setData(medicos);
            medico.setMessage("200");
            medico.setStatus(HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(medico);
        }
    }

}
