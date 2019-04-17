package at.nacs.todo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Todo {

  private String id;
  @NotEmpty
  private String title;
  private boolean done;

}
