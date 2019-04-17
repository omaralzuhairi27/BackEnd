package at.nacs.drhouseaccountancy.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  private Patient patient;// (many to one)

  @Enumerated(EnumType.STRING)
  private Kind kind; //(enum)
  private String symptoms;
  private String diagnosis;
  private String provided;// (either the treatment given or the medicine suggested)
  private double cost;
  private boolean paid;
  private LocalDateTime timestamp;

}
