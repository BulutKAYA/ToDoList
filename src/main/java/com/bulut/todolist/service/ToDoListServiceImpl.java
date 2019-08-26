package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoList;
import com.bulut.todolist.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public ToDoList saveOrUpdateList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @Override
    public List<ToDoList> getUserToDoList(Long id) {
        return null;
    }
}
