package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoList;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ToDoListService {
    ToDoList saveOrUpdateList(ToDoList toDoList);
    void deleteById(Long id);
    List<ToDoList> getUserToDoList(Long id);
}
