package mz.co.ayamed.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "perfil")
public class Perfil {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nome;

}
