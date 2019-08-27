package com.bulut.todolist.web;

import com.bulut.todolist.model.ToDoItem;
import com.bulut.todolist.model.ToDoList;
import com.bulut.todolist.service.ToDoItemService;
import com.bulut.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/todolist")
@RequestMapping(value = "/api/todolist")
@CrossOrigin
public class ToDoListController {
    @Autowired
    private ToDoListService toDoListService;

    @Autowired
    private MessageSource messageProvider;

    @PostMapping("/saveorupdate")
    private ToDoList saveOrUpdateTodoList(@Valid @RequestBody ToDoList toDoList){
        return toDoListService.saveOrUpdateList(toDoList);
    }

    @PostMapping("/delete")
    private void deleteToDoList(Long id){
        toDoListService.deleteById(id);
    }

    @GetMapping("/list")
    private List<ToDoList> getListItems(Long id){
        return toDoListService.getUserToDoList(id);
    }
}
