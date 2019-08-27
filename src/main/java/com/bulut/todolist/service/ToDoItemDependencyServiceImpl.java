package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoItemDependency;
import com.bulut.todolist.repository.ToDoItemDependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoItemDependencyServiceImpl implements ToDoItemDependencyService {

    @Autowired
    private ToDoItemDependencyRepository toDoItemDependencyRepository;

    @Override
    public ToDoItemDependency saveOrUpdateDependency(ToDoItemDependency dependency) {
        return toDoItemDependencyRepository.save(dependency);
    }

    @Override
    public void deleteById(Long id) {
        toDoItemDependencyRepository.deleteById(id);
    }

    @Override
    public List<ToDoItemDependency> getItemDependencys(Long list_id, Long id) {
        return toDoItemDependencyRepository.getItemDependencys(list_id, id);
    }
}
