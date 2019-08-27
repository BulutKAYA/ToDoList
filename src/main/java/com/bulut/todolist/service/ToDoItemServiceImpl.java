package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoItem;
import com.bulut.todolist.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Override
    public ToDoItem saveOrUpdateToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @Override
    public void deleteById(Long id) {
        toDoItemRepository.deleteById(id);
    }

    @Override
    public List<ToDoItem> getToDoItemsOfList(Long id) {
        return toDoItemRepository.getToDoItemsOfList(id);
    }
}
