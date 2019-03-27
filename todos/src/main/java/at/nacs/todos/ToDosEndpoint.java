package at.nacs.todos;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDosEndpoint {

    private final ToDoRepository repository;

    @GetMapping
    List<ToDo> get() {
        return repository.findAll();
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return repository.save(toDo);
    }
}
