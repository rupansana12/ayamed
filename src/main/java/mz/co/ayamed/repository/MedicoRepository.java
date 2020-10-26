package mz.co.ayamed.repository;

import mz.co.ayamed.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    @Modifying
    @Query(value = "SELECT med FROM Medico AS med JOIN FETCH med.especializacaoId esp LEFT JOIN FETCH med.categoriaId cat LEFT JOIN FETCH med.perfilId perf WHERE esp.id = ?1")

    List<Medico> buscarProfissionaiasPorEspecialidade(long id);
}
