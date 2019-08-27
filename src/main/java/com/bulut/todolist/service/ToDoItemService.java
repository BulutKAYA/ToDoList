package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoItem;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ToDoItemService {
    ToDoItem saveOrUpdateToDoItem(ToDoItem toDoItem);
    void deleteById(Long id);
    List<ToDoItem> getToDoItemsOfList(Long id);
}
