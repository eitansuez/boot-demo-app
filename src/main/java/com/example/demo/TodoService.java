package com.example.demo;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

  private final TodoJpaRepository todoRepository;
  private CounterService counter;

  public TodoService(TodoJpaRepository todoRepository, CounterService counter) {
    this.todoRepository = todoRepository;
    this.counter = counter;
  }

  public Todo addTodo(Todo todo) {
    Todo added = todoRepository.save(todo);
    counter.increment("demo.todos.added");
    return added;
  }

  public List<Todo> findAll() {
    return todoRepository.findAll();
  }

  public Optional<Todo> findById(Long id) {
    return todoRepository.findById(id);
  }

  public void delete(Todo todo) {
    todoRepository.delete(todo);
  }

  public boolean isEmpty() {
    return todoRepository.count() == 0;
  }
}
