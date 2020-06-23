package com.todo.TodoApp.api;

import com.todo.TodoApp.model.TodoItem;
import com.todo.TodoApp.service.TodoItemService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class TodoItemController {

  @Autowired
  private TodoItemService itemService;

  @GetMapping("/item/{itemId}")
  public TodoItem getItem(@PathVariable Long itemId) {
    return itemService.getItem(itemId);
  }

  // Get todo list, based on listId
  @GetMapping("/list/{listId}")
  public List<TodoItem> getItem(@PathVariable UUID listId) {
    return itemService.getAllListTodoItemForListID(listId);
  }

  @GetMapping("/List")
  public  List<TodoItem> getList(){
    return itemService.getAllList();
  }

  // New todo item
  @PostMapping(value = "/new")
  public ResponseEntity<TodoItem> newTodoItem(@RequestBody TodoItem item) {
    return ResponseEntity.ok(itemService.saveTodoItem(item));
  }

  // Edit todo item
  @PutMapping("/edit")
  public ResponseEntity<TodoItem> editTodoItem(@RequestBody TodoItem item) {
    return ResponseEntity.ok(itemService.editTodo(item));
  }

  // Delete todo item
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Boolean> deleteTodoItem(@PathVariable Long id) {
    return ResponseEntity.ok(itemService.deleteTodo(id));
  }

  // Change done state
  @PutMapping("/state/{id}")
  public ResponseEntity<TodoItem> changeDoneState(@PathVariable Long id) {
    return ResponseEntity.ok(itemService.changeDoneStatusForItem(id));
  }



}
