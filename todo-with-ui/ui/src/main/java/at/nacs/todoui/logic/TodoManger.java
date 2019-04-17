package at.nacs.todoui.logic;

import at.nacs.todoui.persistence.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoManger {
  private final RestTemplate restTemplate;
  @Value("${todo.url}")
  private String url;

  public List<Todo> findAll(){
    Todo[] toDoArray = restTemplate.getForObject(url, Todo[].class);
    return Arrays.asList(toDoArray);
  }

  public Todo addToDo(Todo todo){
    return restTemplate.postForObject(url,todo,Todo.class);
  }
  public void deleteTodo(String id){
    restTemplate.delete(url+"/"+id);
  }

  public void setDone(String id){
    restTemplate.put(url+"/"+id+"/done",Todo.class);
  }



}
