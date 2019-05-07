package at.nacs.securitydatabase.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Participant {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;
}
