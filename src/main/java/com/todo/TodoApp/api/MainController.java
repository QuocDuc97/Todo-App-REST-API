package com.todo.TodoApp.api;

import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {

  public String index(Model model){
    //when people visit site create an UUID for a list and return it
    UUID uuid= UUID.randomUUID();
    model.addAttribute("listID",uuid.toString());
    return "index";
  }

}
