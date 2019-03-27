package at.nacs.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoEndpoint {

    private final ToDoManager toDoManager;

    @GetMapping
    List<Todo> get() {
        return toDoManager.findAll();
    }

    @GetMapping("/{id}")
    Optional<Todo> get(@PathVariable String id) {
        return toDoManager.findById(id);
    }

    @GetMapping("/{id}/done")
    boolean isDone(@PathVariable String id) {
        return toDoManager.isDoneTodo(id);
    }

    @PostMapping
    Todo post(@RequestBody Todo toDo) {
        return toDoManager.postTodo(toDo);
    }

    @PutMapping("/{id}/done")
    Todo update(@PathVariable String id) {
        return toDoManager.updateTodo(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        toDoManager.deleteTodo(id);
    }
}
