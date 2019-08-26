package com.bulut.todolist.service;


import com.bulut.todolist.model.ToDoItemDependency;

import java.util.List;

public interface ToDoItemDependencyService {
    ToDoItemDependency saveOrUpdateDependency(ToDoItemDependency dependency);
    List<ToDoItemDependency> getItemDependencys(Long id);
}
