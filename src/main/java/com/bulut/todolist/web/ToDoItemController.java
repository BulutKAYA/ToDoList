package com.bulut.todolist.web;

import com.bulut.todolist.model.ToDoItem;
import com.bulut.todolist.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/todoitem")
@RequestMapping(value = "/api/todoitem")
@CrossOrigin
public class ToDoItemController {

    @Autowired
    private ToDoItemService toDoItemService;

    @Autowired
    private MessageSource messageProvider;

    @PostMapping("/saveorupdate")
    private ToDoItem saveOrUpdateTodoItem(@Valid @RequestBody ToDoItem toDoItem){
        return toDoItemService.saveOrUpdateToDoItem(toDoItem);
    }

    @PostMapping("/delete")
    private void deleteToDoItem(Long id){
        toDoItemService.deleteById(id);
    }

    @GetMapping("/itemlist")
    private List<ToDoItem> getListItems(Long id){
        return toDoItemService.getToDoItemsOfList(id);
    }
}
