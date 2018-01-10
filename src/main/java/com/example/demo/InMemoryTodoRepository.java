package com.example.demo;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public final class InMemoryTodoRepository implements TodoRepository {

  private final Map<Long, Todo> todoMap = new HashMap<>();

  private final AtomicLong sequence = new AtomicLong(0);

  @Override
  public Todo save(Todo todo) {
    if (todo.getId() == null) {
      Long id = sequence.incrementAndGet();
      Todo todoWithId = todo.toBuilder().id(id).build();
      todoMap.put(id, todoWithId);
      return todoWithId;
    } else {
      todoMap.replace(todo.getId(), todo);
      return todo;
    }
  }

  @Override
  public void delete(Todo todo) {
    todoMap.remove(todo.getId());
  }

  @Override
  public Optional<Todo> findById(Long id) {
    return Optional.ofNullable(todoMap.get(id));
  }

  @Override
  public long count() {
    return todoMap.size();
  }

  @Override
  public List<Todo> findAll() {
    return new ArrayList<>(todoMap.values());
  }
}
