package com.bulut.todolist.repository;


import com.bulut.todolist.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    @Query("SELECT a.id, a.user_id, a.name, a.create_date as createDate, a.modify_date as modifyDate  " +
            "FROM ToDoList a  where a.user_id = :id")
    List<ToDoList> getUserToDoList(@Param("id") Long id);
}

