package com.todo.TodoApp.dao;

import com.todo.TodoApp.model.TodoItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {


Optional <TodoItem> findByItemID(Long itemID);
  List<TodoItem> findByListID(UUID listID);

}
