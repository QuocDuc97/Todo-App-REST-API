package com.todo.TodoApp.api;

import com.todo.TodoApp.model.TodoItem;
import com.todo.TodoApp.service.TodoItemService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class TodoItemController {

  @Autowired
  private TodoItemService itemService;

  @GetMapping("/item/{id}")
  public TodoItem getItem(@PathVariable Long id){
    return itemService.getItem(id);
  }


  //get todolist by listid
  @GetMapping("item/{listId}")
  public List<TodoItem> getListTodo(@PathVariable UUID listId){
    return itemService.getAllListTodoItemForListID(listId);
  }




}
