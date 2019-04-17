package at.nacs.todoui.controller;

import at.nacs.todoui.logic.TodoManger;
import at.nacs.todoui.persistence.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TodoController {

  private final TodoManger manger;
  @ModelAttribute("todo")
  Todo todo() {
    return new Todo();
  }

  @ModelAttribute("todos")
  List<Todo> todos() {
    List<Todo> todos = manger.findAll();
    return todos;
  }
  @PostMapping
  String post(@Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    manger.addToDo(todo);
    return "redirect:/";
  }
  @PostMapping("/delete")
  String delete(@RequestParam String id) {
    manger.deleteTodo(id);
    return "redirect:/";
  }
  @GetMapping
  String page() {return "todo";
  }
  @PostMapping("/done")
  String setDone(@RequestParam String id) {
    manger.setDone(id);
    return "redirect:/";
  }

}
