package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoItem;

import java.util.List;

public interface ToDoItemService {
    ToDoItem saveOrUpdateToDoItem(ToDoItem toDoItem);
    List<ToDoItem> getUserToDoItemsOfList(Long id);
}
