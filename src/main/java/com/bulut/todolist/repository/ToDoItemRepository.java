package com.bulut.todolist.repository;

import com.bulut.todolist.model.ToDoItem;
import com.bulut.todolist.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
    @Query(value = "SELECT * FROM ToDoItem a  where a.list_id=:id", nativeQuery = true)
    List<ToDoItem> getToDoItemsOfList(@Param("id") Long id);
}