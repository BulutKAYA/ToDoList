package com.bulut.todolist.repository;


import com.bulut.todolist.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    @Query(value = "SELECT a.id, a.user_id, a.name, a.create_date, a.modify_date " +
            "FROM ToDoList a  where a.user_id = :id", nativeQuery = true)
    List<ToDoList> getUserToDoList(@Param("id") Long id);
}

