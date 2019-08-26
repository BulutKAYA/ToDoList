package com.bulut.todolist.repository;

import com.bulut.todolist.model.ToDoItemDependency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ToDoItemDependencyRepository extends JpaRepository<ToDoItemDependency, Long> {

    @Query("SELECT a.id, a.list_id, a.dependencyitem_id, a.independencyitem_id  " +
            "FROM ToDoItemdDependency a  where a.list_id = :id ")
    List<ToDoItemDependency> getItemDependencys(@Param("id") Long id);
}