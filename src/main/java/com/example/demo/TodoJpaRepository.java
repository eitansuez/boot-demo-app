package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

  default Optional<Todo> findById(Long id) {
    return Optional.ofNullable(findOne(id));
  }
}
