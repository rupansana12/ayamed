package mz.co.ayamed.domain;


import lombok.Data;
import mz.co.ayamed.domain.Especializacao;
import mz.co.ayamed.domain.Medico;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "marcar_consulta")
public class MarcarConsulta {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "especialidade_id")
  private Especializacao especialidadeId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medico_id")
  private Medico medicoId;
  @Column(name = "nome_cliente")
  private String nomeCliente;
  @Column(name = "contacto_cliente")
  private String contactoCliente;
  @Column(name = "email_cliente")
  private String emailCliente;
  private Date data;
  @Column(name = "created_at")
  private Date createdAt;

}
