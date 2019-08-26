package com.bulut.todolist.repository;

import com.bulut.todolist.model.ToDoItem;
import com.bulut.todolist.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
    @Query("SELECT a.id, a.list_id, a.name, a.description, a.dead_line, a.create_date, a.modify_date " +
            "FROM ToDoItem a  where a.list_id= :id")
    List<ToDoItem> getUserToDoItemsOfList(@Param("id") Long id);
}