package mz.co.ayamed.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "medico")
public class Medico {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nome;
  private String titulo;
  private String sexo;
  private String aplicacao;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoria_id")
  private Categoria categoriaId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "perfil_id")
  private Perfil perfilId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "especialidade_id")
  private Especializacao  especializacaoId;
}
