package at.nacs.administration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
  @NotEmpty
  private String name;
  @NotEmpty
  private String symptoms;
}
