package com.todo.TodoApp.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


//@Entity using jpa
@Entity
//using lombok @Data = getter+setter+string
@Data
@Table(name = "tblTodoItem")
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "itemID")
  private Long itemID;

  @Column(name = "listID")
  //Sử dụng UUIDGenerator Hibernate. voi postgresql type="pg-uuid"/ mysql: @Type(type = "uuid-char") @Column(length = 36)
  @Type(type = "pg-uuid")
  private UUID listID;

  @Column(name = "taskName")
  @NotEmpty(message = "* Enter task name")
  private String taskName;

  @Column(name = "isDone")
  private Boolean isDone = false;//default values

  @Column(name = "createAt")
  private Date createAt = new Date();

}
