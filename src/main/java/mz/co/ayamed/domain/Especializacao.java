package mz.co.ayamed.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "especializacao")
public class Especializacao {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nome;



}
