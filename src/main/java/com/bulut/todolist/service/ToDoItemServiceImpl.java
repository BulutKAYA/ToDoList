package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoItem;
import com.bulut.todolist.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;
    @Override
    public ToDoItem saveOrUpdateToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @Override
    public List<ToDoItem> getUserToDoItemsOfList(Long id) {
        return null;
    }
}
