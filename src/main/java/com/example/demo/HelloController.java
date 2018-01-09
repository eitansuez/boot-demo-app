package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public Map sayHello() {
    Map<String, String> map = new HashMap<>();
    map.put("message", "Hello world");
    return map;
  }

}
