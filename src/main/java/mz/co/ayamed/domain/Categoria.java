package mz.co.ayamed.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nome;
}
