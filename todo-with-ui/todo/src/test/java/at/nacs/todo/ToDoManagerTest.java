package at.nacs.todo;

import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ConfigurationProperties("dataset")
class ToDoManagerTest {

  @Autowired
  ToDoManager toDoManager;

  @Autowired
  TodoRepository repository;

  @Setter
  List<Todo> todos;


  @BeforeEach
  void before() {
    repository.saveAll(todos);
  }

  @AfterEach
  void after() {
    repository.deleteAll();
  }

  @Test
  void TestFindAll() {
    List<Todo> todos = toDoManager.findAll();


  }

  @Test
  void TestfindById() {
    List<Todo> todos = toDoManager.findAll();
    Todo todo = todos.get(0);
    Optional<Todo> findbyId = toDoManager.findById(todo.getId());
    assertThat(findbyId.get().getTitle()).isEqualTo("sleep");
  }

  @Test
  void isDoneTodo() {
  }

  @Test
  void postTodo() {
  }

  @Test
  void updateTodo() {
  }

  @Test
  void deleteTodo() {
  }
}