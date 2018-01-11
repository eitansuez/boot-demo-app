package com.example.demo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder(toBuilder = true)
@Data
public class Todo {
  @Id @GeneratedValue
  private final Long id;
  private final String title, description;
  private final LocalDate dueDate;
}
