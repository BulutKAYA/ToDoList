package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoItemDependency;
import com.bulut.todolist.repository.ToDoItemDependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ToDoItemDependencyServiceImpl implements ToDoItemDependencyService {

    @Autowired
    private ToDoItemDependencyRepository toDoItemDependencyRepository;

    @Override
    public ToDoItemDependency saveOrUpdateDependency(ToDoItemDependency dependency) {
        return toDoItemDependencyRepository.save(dependency);
    }

    @Override
    public List<ToDoItemDependency> getItemDependencys(Long id) {
        return null;
    }
}
