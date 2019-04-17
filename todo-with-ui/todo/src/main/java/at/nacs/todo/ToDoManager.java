package at.nacs.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoManager {

  private final TodoRepository repository;

  List<Todo> findAll() {
    return repository.findAll();
  }

  Optional<Todo> findById(String id) {
    return repository.findById(id);
  }

  boolean isDoneTodo(String id) {
    return repository.findById(id).get().isDone();
  }

  Todo postTodo(Todo toDo) {
    return repository.save(toDo);
  }

  Todo updateTodo(String id) {
    if (!repository.existsById(id)) {
      return null;
    }
    Todo todo = repository.findById(id).get();
    todo.setDone(true);
    repository.save(todo);
    return todo;
  }

  void deleteTodo(String id) {
    repository.findById(id).ifPresent(e -> repository.delete(e));
  }
}
