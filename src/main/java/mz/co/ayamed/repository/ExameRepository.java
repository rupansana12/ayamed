package mz.co.ayamed.repository;

import mz.co.ayamed.domain.Exame;
import mz.co.ayamed.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExameRepository extends JpaRepository<Exame,Long> {
    @Query(value = "SELECT exa FROM Exame as exa JOIN FETCH exa.especialidadeId",nativeQuery = false)
    List<Exame> findAll();
}
