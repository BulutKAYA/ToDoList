package com.bulut.todolist.service;

import com.bulut.todolist.model.ToDoList;
import com.bulut.todolist.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public ToDoList saveOrUpdateList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @Override
    public void deleteById(Long id) {
        toDoListRepository.deleteById(id);
    }

    @Override
    public List<ToDoList> getUserToDoList(Long id) {
        return toDoListRepository.getUserToDoList(id);
    }
}
