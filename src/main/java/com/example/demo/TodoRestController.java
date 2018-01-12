package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {

  private final TodoService service;

  public TodoRestController(TodoService service) {
    this.service = service;
  }

  @GetMapping
  public List<Todo> list() {
    return service.findAll();
  }

  @GetMapping("{id}")
  public ResponseEntity<Todo> get(@PathVariable Long id) {
    Optional<Todo> optional = service.findById(id);
    return optional.isPresent() ?
        ResponseEntity.ok(optional.get()) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Todo> create(@RequestBody Todo todo) {
    Todo savedTodo = service.addTodo(todo);
    return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Todo> delete(@PathVariable Long id) {
    Optional<Todo> optional = service.findById(id);
    if (optional.isPresent()) {
      service.delete(optional.get());
    }
    return ResponseEntity.noContent().build();
  }

}
