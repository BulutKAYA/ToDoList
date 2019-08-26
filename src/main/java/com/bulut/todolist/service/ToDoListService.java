package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoList;

import java.util.List;

public interface ToDoListService {
    ToDoList saveOrUpdateList(ToDoList toDoList);
    List<ToDoList> getUserToDoList(Long id);
}
