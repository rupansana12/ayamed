package mz.co.ayamed.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "analise")
public class Analise {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String designacao;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tipo_analise_id")
  private TipoAnalise tipoAnaliseId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "instituicao_id")
  private Instituicao instituicaoId;

}
