package mz.co.ayamed.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exame")
public class Exame {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nome;

  @Fetch(FetchMode.JOIN)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "especialidade_id")
  private Especializacao especialidadeId;

}
