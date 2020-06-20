package com.todo.TodoApp.dao;

import com.todo.TodoApp.model.TodoItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TodoItemRepository")
public interface TodoItemData extends JpaRepository<TodoItem, Long> {


Optional <TodoItem> findTodoItemByID(Long itemID);
  List<TodoItem> findListItemID(UUID listID);

}
