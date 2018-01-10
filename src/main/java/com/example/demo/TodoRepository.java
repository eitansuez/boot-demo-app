package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
  List<Todo> findAll();
  Todo save(Todo todo);
  void delete(Todo todo);
  Optional<Todo> findById(Long id);
  long count();
}
