package com.todo.TodoApp.service;

import com.todo.TodoApp.dao.TodoItemData;
import com.todo.TodoApp.model.TodoItem;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {

  @Autowired
  TodoItemData todoItemData;

  //save todoItem in repo

  public TodoItem saveTodoItem(TodoItem item){
    return todoItemData.save(item);
  }

  //change done status for item in repo
  public TodoItem changeDoneStatusForItem(Long id){

    //find item change
    TodoItem todo= todoItemData.findTodoItemByID(id).orElse(null);
    if(todo!=null){
      todo.setIsDone(!todo.getIsDone());//change status
      todoItemData.save(todo);//save todoitem after change
      return todo;
    }
    return null;

  }

  //delete todoItem
  public Boolean deleteTodo(Long id){
    //find item delete
    TodoItem todo= todoItemData.findTodoItemByID(id).orElse(null);
    if (todo!=null){
      todoItemData.delete(todo);
      return true;
    }
    return false;
  }

  //edit todoItem
  public TodoItem editTodo(TodoItem edittodoItem){
    TodoItem todo= todoItemData.findTodoItemByID(edittodoItem.getItemID()).orElse(null);
    if (todo!=null){
      todo.setTaskName(edittodoItem.getTaskName());
      return todoItemData.save(todo);
    }

    //create new
    return todoItemData.save(todo);

  }

  //get all list todoitem for list id
  public List<TodoItem> getAllListTodoItemForListID(UUID listId){
    return todoItemData.findListItemID(listId);
  }

  //get item

  public TodoItem getItem(Long id){
    return todoItemData.findTodoItemByID(id).get();
  }


}
