package com.todo.TodoApp.service;

import com.todo.TodoApp.dao.TodoItemRepository;
import com.todo.TodoApp.model.TodoItem;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {

  @Autowired
  TodoItemRepository todoItemRepository;

  //save todoItem in repo

  public TodoItem saveTodoItem(TodoItem item){
    item.setListID(UUID.randomUUID());
    return todoItemRepository.save(item);
  }

  //change done status for item in repo
  public TodoItem changeDoneStatusForItem(Long id){

    //find item change
    TodoItem todo= todoItemRepository.findByItemID(id).orElse(null);
    if(todo!=null){
      todo.setIsDone(!todo.getIsDone());//change status
      todoItemRepository.save(todo);//save todoitem after change
      return todo;
    }
    return null;

  }

  //delete todoItem
  public Boolean deleteTodo(Long id){
    //find item delete
    TodoItem todo= todoItemRepository.findByItemID(id).orElse(null);
    if (todo!=null){
      todoItemRepository.delete(todo);
      return true;
    }
    return false;
  }

  //edit todoItem
  public TodoItem editTodo(TodoItem edittodoItem){
    TodoItem todo= todoItemRepository.findByItemID(edittodoItem.getItemID()).orElse(null);
    if (todo!=null){
      todo.setTaskName(edittodoItem.getTaskName());
      return todoItemRepository.save(todo);
    }

    //create new
    return todoItemRepository.save(todo);

  }

  //get all list todoitem for list id
  public List<TodoItem> getAllListTodoItemForListID(UUID listId){
    return todoItemRepository.findByListID(listId);
  }

  //get item

  public TodoItem getItem(Long id){
    return todoItemRepository.findByItemID(id).get();
  }


}
