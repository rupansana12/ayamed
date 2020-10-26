package mz.co.ayamed.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tipo_analise")
public class TipoAnalise {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String descricao;
  @ManyToOne(fetch = FetchType.LAZY)
  private Especializacao especializacaoId;

}
