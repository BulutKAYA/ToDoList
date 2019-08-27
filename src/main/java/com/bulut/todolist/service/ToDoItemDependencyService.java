package com.bulut.todolist.service;


import com.bulut.todolist.model.ToDoItemDependency;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ToDoItemDependencyService {
    ToDoItemDependency saveOrUpdateDependency(ToDoItemDependency dependency);
    void deleteById(Long id);
    List<ToDoItemDependency> getItemDependencys(Long list_id, Long id);
}
