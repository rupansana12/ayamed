package mz.co.ayamed.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "marcar_exame")
public class MarcarExame {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "exame_id")
  private Exame exameId;
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
