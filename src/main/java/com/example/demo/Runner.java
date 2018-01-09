package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  private final HelloService helloService;

  public Runner(HelloService helloService) {
    this.helloService = helloService;
  }

  @Override
  public void run(String... args) throws Exception {
    helloService.greet();
  }
}
